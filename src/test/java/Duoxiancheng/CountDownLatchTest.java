package Duoxiancheng;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 等待线程
 *
 * @author zzs .
 * @since 2018/6/26
 */
public class CountDownLatchTest {

    //用来维护运动员需要依赖裁判的哨响
    private static CountDownLatch startSignal = new CountDownLatch(1);
    //用来表示裁判员需要维护的是6个运动员
    private static CountDownLatch endSignal = new CountDownLatch(6);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 6; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 运动员等待裁判员响哨！！！");
                    startSignal.await();
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "正在全力冲刺");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " 到达终点");
                    endSignal.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(1000);
        startSignal.countDown();
        System.out.println("裁判员发号施令啦！！！");
        endSignal.await();
        System.out.println("所有运动员到达终点，比赛结束！");
        executorService.shutdown();
    }

}
