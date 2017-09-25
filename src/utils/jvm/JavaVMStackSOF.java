package utils.jvm;

/**
 * -Xss 128k  每个线程的堆栈大小,这个值越小，减小这个值能生成更多的线程.jdk1.5以后默认是1M
 * -XX:PermSize	设置持久代(perm gen)初始值	-----方法区和运行时常量
 * -XX:MaxPermSize	设置持久代(perm gen)最大值	-----方法区和运行时常量
 * -XX:MaxDirectMemorySize  制定直接本地内存的最大值，不指定，则与-Xmx一致 DirectByteBuffer内存分配到直接本地内存
 * Created by gezz on 2017/9/12.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stackLength:" +oom.stackLength);
            throw throwable;
        }
    }
}
