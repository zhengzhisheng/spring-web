package lock.distribute;

import com.sheng.Lock.Thread1;
import com.sheng.Lock.Thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zzs .
 * @since 2019/6/20
 */
public class ThreadMain {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(t1);
        exec.execute(t2);
        exec.shutdown();
    }
}
