package Duoxiancheng;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zs
 * @date 2020/11/26 2:28 下午
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
//        run();
        reRun();
    }

    public static void run() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(new Random().nextInt(3)*1000);
                    System.out.println(Thread.currentThread().getName() + "，准备好了");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "，开跑");
            }, "运动员" + i).start();
        }

    }

    public static void reRun() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(new Random().nextInt(3)*1000);
                    System.out.println(Thread.currentThread().getName() + "，准备好了");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "，开跑");
            }, "中国运动员" + i).start();
        }

        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("========下一波开始准备=========");
        cyclicBarrier.reset();

        for (int i = 0; i < 10; i++) {
            new Thread(()-> {
                try {
                    Thread.sleep(new Random().nextInt(3)*1000);
                    System.out.println(Thread.currentThread().getName() + "，准备好了");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "，开跑");
            }, "美国运动员" + i).start();
        }
    }
}
