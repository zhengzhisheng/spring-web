package Duoxiancheng.Lock.DeadLock;

/**
 * 死锁
 *
 * @author zzs .
 * @since 2018/3/24
 */
public class DeadLock {

    private Object left = new Object();

    private Object right = new Object();

    public void leftRight() throws Exception
    {
        synchronized (left)
        {
            Thread.sleep(2000);
            synchronized (right)
            {
                System.out.println("leftRight end!");
            }
        }
    }

    public void rightLeft() throws Exception
    {
        synchronized (right)
        {
            Thread.sleep(2000);
            synchronized (left)
            {
                System.out.println("rightLeft end!");
            }
        }
    }

    static class Thread0 extends Thread {

        private DeadLock deadLock;

        public Thread0(DeadLock deadLock){
            this.deadLock = deadLock;
        }

        public void run() {
            try {
                deadLock.leftRight();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Thread1 extends Thread{

        private DeadLock deadLock;

        public Thread1(DeadLock deadLock){
            this.deadLock = deadLock;
        }

        public void run() {
            try {
                deadLock.rightLeft();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        Thread0 thread0 = new Thread0(deadLock);
        Thread1 thread1 = new Thread1(deadLock);

        thread0.start();
        thread1.start();
    }
}
