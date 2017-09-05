package utils.nio.test;

import org.junit.Test;
import utils.nio.PipeUtils;

import java.io.IOException;
import java.nio.channels.Pipe;

/**
 * Created by gezz on 2017/8/14.
 */
public class PipTest {
    @Test
    public void testPipe() {
        Pipe pipe = null;
        try {
            pipe = Pipe.open();
            String str = "Pipe String !";
            PipeUtils.write(pipe,str);
            PipeUtils.read(pipe);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
