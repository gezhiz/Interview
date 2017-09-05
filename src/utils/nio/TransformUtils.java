package utils.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gezz on 2017/8/13.
 */
public class TransformUtils {

    public static void copyFile(String fromPath, String toPath) {
        try {
            RandomAccessFile from = new RandomAccessFile(fromPath,"rw");
            RandomAccessFile to = new RandomAccessFile(toPath, "rw");
            FileChannel fromChannel = from.getChannel();
            FileChannel toChannel = to.getChannel();
            int position = 0;
            long count = fromChannel.size();//文件字节书
            toChannel.transferFrom(fromChannel,position,count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 追加拷贝
     * @param fromPath
     * @param toPath
     */
    public static void copyAddFile(String fromPath, String toPath) {
        try {
            RandomAccessFile from = new RandomAccessFile(fromPath,"rw");
            RandomAccessFile to = new RandomAccessFile(toPath, "rw");
            FileChannel fromChannel = from.getChannel();
            FileChannel toChannel = to.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while(fromChannel.read(byteBuffer) != -1 ) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    toChannel.position(toChannel.size());
                    toChannel.write(byteBuffer);
                }
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
