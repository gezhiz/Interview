package utils.nio.test;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by gezz on 2017/9/5.
 */
public class SelectorTest {

    //运行程序之后，在浏览器中输入localhost:8080,即可访问socket
    @Test
    public void testServer() {
        server("localhost", 8080);
    }

    @Test
    public void testClient() {
        client("localhost",9999);
    }

    private void client(String url, int port) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",port));
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            while (true) {
                if (socketChannel.finishConnect()) {
                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                    writeBuffer.put("客户端发送的数据".getBytes());
                    socketChannel.write(writeBuffer);
                    socketChannel.read(byteBuffer);
                    byteBuffer.flip();//开始读取数据
                    System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

    private void server(String url, int port){
        ServerSocketChannel serverSocketChannel = null;
        Selector selector = null;
        SelectionKey selKey = null;
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(url, port));
            selector = Selector.open();
            selKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        if ((selKey.interestOps() & SelectionKey.OP_ACCEPT )== SelectionKey.OP_ACCEPT) {
//            System.out.println("selector对serverSocketChannel的OP_ACCEPT时间感兴趣");
//        }
//        if(selKey.isAcceptable()) {
//            System.out.println("serverSocketChannel目前是可以接收请求的状态");
//        }
        while(true) {
            int readyChannelCount = 0;
            try {
                readyChannelCount = selector.select();//阻塞到至少有一个通道在你注册的事件上就绪了。如果一直有事件就绪，则不会阻塞
            } catch (IOException e) {
                e.printStackTrace();
                if (selector != null) {
                    try {
                        selector.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();//获取已经注册的通道
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                try {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();
                    if (selectionKey.isAcceptable()) {
//                        ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();//SelectableChannel
                        SocketChannel client = serverSocketChannel.accept();
                        client.configureBlocking(false);
                        //注意：因为socket总是处于可读状态，同时注册读和写的事件会导致selector一直处于非阻塞状态，大量浪费cpu
//                            client.register(selector, SelectionKey.OP_WRITE|SelectionKey.OP_READ);
                        client.register(selector, SelectionKey.OP_READ);//注册的读事件会被selector拦截并处理掉
                    } else if (selectionKey.isReadable()) {
                        //可读
//                        SocketChannel client = (SocketChannel) selectionKey.channel();
//                        client.configureBlocking(false);
                        selectionKey.interestOps(SelectionKey.OP_WRITE);//register的注册事件会覆盖掉之前client注册的OP_READ事件
//                            client.register(selector, SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {
                        //可写
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        byteBuffer.clear();
                        String httpResponse = "HTTP/1.1 200 OK\r\n" +
                                "Content-Length: 38\r\n" +
                                "Content-Type: text/html\r\n" +
                                "\r\n" +
                                "<html><body>Hello World!</body></html>";
                        byte[] bytes = httpResponse.getBytes();
                        byteBuffer.put(bytes, 0, bytes.length);
                        byteBuffer.flip();
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        client.write(byteBuffer);
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
            }
            if (readyChannelCount == 0) {
                continue;
            }
        }
    }
}
