package Duoxiancheng.DeadLock;

/**
 * @author zzs .
 * @since 2018/3/24
 */
public class Thread0 extends Thread {

    private DeadLock deadLock;

    public Thread0(DeadLock deadLock){
        this.deadLock = deadLock;
    }

    public void run() {
        try {
//            deadLock.leftRight();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
