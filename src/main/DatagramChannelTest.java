package main;

import org.junit.Test;
import utils.nio.NioDatagramChannelUtils;

import java.net.InetSocketAddress;

/**
 * Created by gezz on 2017/8/14.
 */
public class DatagramChannelTest {

    @Test
    public void testReceive() {
        NioDatagramChannelUtils.receive(8888);
    }

    @Test
    public void testSend() {
        NioDatagramChannelUtils.write(new InetSocketAddress("localhost",8888));
    }
}
