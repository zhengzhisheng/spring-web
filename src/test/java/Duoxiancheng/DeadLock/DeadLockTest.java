package Duoxiancheng.DeadLock;

/**
 * @author zzs .
 * @since 2018/3/24
 */
public class DeadLockTest {

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        Thread0 thread0 = new Thread0(deadLock);
        Thread1 thread1 = new Thread1(deadLock);

        thread0.start();
        thread1.start();
    }
}
