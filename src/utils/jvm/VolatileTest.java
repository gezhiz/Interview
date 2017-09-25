package utils.jvm;

/**
 * Created by gezz on 2017/9/21.
 */
public class VolatileTest {
    public static volatile int race = 0;
    public static void increase() {
        synchronized(VolatileTest.class) {
            race ++;
        }
    }
    private static final int THREADS_COUNT = 2;
    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i =0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //等待所有累加线程结束
        while(Thread.activeCount() > 1) {
            /**
             * Yield是一个静态的原生(native)方法
             Yield告诉当前正在执行的线程把运行机会交给线程池中拥有相同优先级的线程。
             Yield不能保证使得当前正在运行的线程迅速转换到可运行的状态
             它仅能使一个线程从运行状态转到可运行状态，而不是等待或阻塞状态
             */
            Thread.yield();
            System.out.println(race);
        }
    }
}
