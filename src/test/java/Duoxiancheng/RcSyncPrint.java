package Duoxiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zzs .
 * @since 2018/6/13
 */
public class RcSyncPrint implements Runnable{

    private final Integer MAX_COUNT = 10;
    private ReentrantLock reentrantLock;
    private Condition thisCondition;
    private Condition nextCondition;
    private String printStr;

    public RcSyncPrint(ReentrantLock reentrantLock,Condition thisCondition,Condition nextCondition,String printStr){
        this.reentrantLock = reentrantLock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printStr = printStr;
    }

    @Override
    public void run() {
        reentrantLock.lock();

        try{
            for (int i=0;i<MAX_COUNT;i++) {
                System.out.print(this.printStr);
                nextCondition.signal();
                try {
                    if (i<MAX_COUNT-1){
                        thisCondition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Condition condition1 = reentrantLock.newCondition();
        Condition condition2 = reentrantLock.newCondition();
        Thread thread = new Thread(new RcSyncPrint(reentrantLock,condition,condition1,"A"));
        Thread thread1 = new Thread(new RcSyncPrint(reentrantLock,condition1,condition2,"B"));
        Thread thread2 = new Thread(new RcSyncPrint(reentrantLock,condition2,condition,"C"));

        thread.start();

        thread1.start();

        thread2.start();
    }

}
