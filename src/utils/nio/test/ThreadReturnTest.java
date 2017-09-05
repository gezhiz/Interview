package utils.nio.test;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created by gezz on 2017/8/16.
 */
public class ThreadReturnTest {

    @Test
    public void testWhile() {
        MyThread thread = new MyThread();
        new Thread(thread).start();
        while (true) {
            if (thread.getValue() != null) {
                System.out.println(thread.getValue());
                break;
            }
        }
    }

    @Test
    public void testCallBack() {
        MyThread thread = new MyThread();
        new Thread(thread).start();
    }

    @Test
    public void testCallBackThread() {
        CallBackThread thread = new CallBackThread(new CallBack() {
            @Override
            public void call() {
                System.out.println("thread执行完成的通知");
            }
        });
        new Thread(thread).start();
    }

    @Test
    public void testFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> integerFuture = executorService.submit(new MyCallable());
        try {
            System.out.println(integerFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void mainThreadCallBack(MyThread thread) {
        System.out.println(thread.getValue());
    }

    static class MyThread implements Runnable {

        private Integer value = null;

        @Override
        public void run() {
            value = 1;
            mainThreadCallBack(this);
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    static class CallBackThread implements Runnable {

        CallBack callBack;

        private CallBackThread() {

        }
        public CallBackThread(CallBack callBack) {
            this.callBack = callBack;
        }

        @Override
        public void run() {
            callBack.call();
        }
    }

    interface CallBack {
        void call();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }

}
