package utils.nio;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
 * Created by gezz on 2017/8/14.
 */
public class PipeUtils {

    public static void write(Pipe pipe, String string) {
        if (string == null || "".equals(string.trim())) {
            throw new IllegalArgumentException("string不能为空");
        }
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.clear();
        byteBuffer.put(string.getBytes());
        try {
            while(byteBuffer.hasRemaining()) {
                sinkChannel.write(byteBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                sinkChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void read(Pipe pipe) {
        try {
            pipe.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            while(sourceChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(),0,byteBuffer.limit()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
