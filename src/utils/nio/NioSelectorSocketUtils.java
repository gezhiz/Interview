package utils.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gezz on 2017/8/14.
 */
public class NioSelectorSocketUtils {

    public static void server(int portNumber) {
        try {
            SocketAddress socketAddress = new InetSocketAddress(portNumber);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(socketAddress);
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
//            while (true) {
//                SocketChannel socketChannel = serverSocketChannel.accept();
//                if (socketChannel != null) {
//                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                    byte[] bytes = new String("strings from nio server!").getBytes();
//                    byteBuffer.put(bytes);
//                    byteBuffer.flip();
//                    socketChannel.write(byteBuffer);
//                    socketChannel.close();
//                }
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void client(SocketAddress socketAddress) throws IOException {
        if (socketAddress == null) {
            throw new IllegalArgumentException("socketAddress不能为空");
        }
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(socketAddress);
            while(socketChannel.finishConnect()) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(8);
                List<Byte> byteList = new ArrayList<Byte>();
                while (socketChannel.read(byteBuffer) != -1) {
                    byteBuffer.flip();
//                System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit(),"utf-8"));
//                while(byteBuffer.hasRemaining()) {
//                    System.out.print((char)byteBuffer.get());//get方法会自动把position往后移动
//                }
                    while (byteBuffer.hasRemaining()) {
                        byteList.add(byteBuffer.get());
                    }
                    byteBuffer.clear();
                }
                byte[] bytes = new byte[byteList.size()];
                for (int i = 0; i < byteList.size(); i++) {
                    bytes[i] = byteList.get(i);
                }
                System.out.println(new String(bytes,0,bytes.length));
                break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketChannel.close();
        }
    }
}
