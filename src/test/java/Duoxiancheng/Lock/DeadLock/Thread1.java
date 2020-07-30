package Duoxiancheng.Lock.DeadLock;

/**
 * @author zzs .
 * @since 2018/3/24
 */
public class Thread1 extends Thread{

    private DeadLock deadLock;

    public Thread1(DeadLock deadLock){
        this.deadLock = deadLock;
    }

    public void run() {
        try {
//            deadLock.rightLeft();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
