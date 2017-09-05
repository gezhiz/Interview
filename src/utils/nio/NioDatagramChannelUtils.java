package utils.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by gezz on 2017/8/14.
 */
public class NioDatagramChannelUtils {

    public static void receive(int portNumber) {
        DatagramChannel datagramChannel = null;
        try {
            datagramChannel = DatagramChannel.open();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            datagramChannel.configureBlocking(false);
            datagramChannel.socket().bind(new InetSocketAddress(portNumber));
            while(true) {
                // 阻塞接受消息
                SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
                if (socketAddress != null) {
                    byteBuffer.flip();
                    System.out.print(new String(byteBuffer.array(),0,byteBuffer.limit(),"utf-8"));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramChannel != null) {
                try {
                    datagramChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void write(InetSocketAddress inetSocketAddress) {
        DatagramChannel datagramChannel = null;
        try {
            datagramChannel = DatagramChannel.open();
            datagramChannel.configureBlocking(false);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byte[] bytes = new String("strings from nio server!").getBytes();
            byteBuffer.put(bytes);
            byteBuffer.flip();
            datagramChannel.connect(inetSocketAddress);
            datagramChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
