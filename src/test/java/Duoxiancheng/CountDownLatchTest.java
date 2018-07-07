package Duoxiancheng;

import java.util.concurrent.CountDownLatch;

/**
 * 等待线程
 *
 * @author zzs .
 * @since 2018/6/26
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + "子线程");
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread() + "主线程");
    }
}
