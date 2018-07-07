package Duoxiancheng;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者-消费者
 *
 * @author zzs .
 * @since 2018/3/24
 */
public class BlockingQueueTest {
    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(20);

    public static void main(String[] args) {
//        BlockingQueueTest test = new BlockingQueueTest();
        new Producer().start();
        new Consumer().start();
//        producer.start();
//        consumer.start();
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try { //从阻塞队列中取出一个元素
                    blockingQueue.take();
                    System.out.println("队列剩余" + blockingQueue.size() + "个元素");
                } catch (InterruptedException e) { }
            }
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try { //向阻塞队列中插入一个元素
                    blockingQueue.put(1);
                    System.out.println("队列剩余空间：" + (20 - blockingQueue.size()));
                } catch (InterruptedException e) { }
            }
        }
    }
}
