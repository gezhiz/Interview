package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by gezz on 2017/8/12.
 */
public class NioReadFileUtils {
    public static void readFile(String filePath) {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(filePath);
            if (!file.isFile()) {
                throw new IllegalArgumentException("参数错误");
            }
            fileInputStream = new FileInputStream(filePath);
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);//分配1024个字节的ByteBuffer
            while (true) {
                byteBuffer.clear();//进入写模式，limit到达capacity
                int len = fileChannel.read(byteBuffer);
                if (len == -1) {
                    break;
                }
                byteBuffer.flip();//进入读模式,limit会被设定为当前的position，position从0开始
//                while(byteBuffer.hasRemaining()) {
//                    System.out.print((char)byteBuffer.get());//get方法会自动把position往后移动
//                }
                System.out.print(new String(byteBuffer.array(),0 ,byteBuffer.limit()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
