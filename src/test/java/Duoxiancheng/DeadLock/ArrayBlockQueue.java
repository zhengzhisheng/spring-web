package Duoxiancheng.DeadLock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author zzs .
 * @since 2018/6/13
 */
public class ArrayBlockQueue {

    private static BlockingQueue blockingQueue = new ArrayBlockingQueue(10);

    static class Product implements Runnable{

        @Override
        public void run() {
            while(true){
//                blockingQueue.put();
            }
        }
    }
}
