package utils.nio.test;

import org.junit.Test;
import utils.nio.NioSocketUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Created by gezz on 2017/8/14.
 */
public class NioSocketTest {

    @Test
    public void testServer() {
        NioSocketUtils.server(8080);
    }

    @Test
    public void testClient() {
        SocketAddress socketAddress = new InetSocketAddress("localhost",8080);
        try {
            NioSocketUtils.client(socketAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
