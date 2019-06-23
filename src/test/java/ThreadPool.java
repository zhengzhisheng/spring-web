import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zzs .
 * @since 2019/4/20
 */
public class ThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

        ExecutorService batchQueryHbaseExecutorService = new ThreadPoolExecutor(10, 20,
                20000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(200),new ThreadPoolExecutor.AbortPolicy());

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("********添加任务！");

                try {
                    for(int i = 1; i < 400; i++){
                        System.out.println("batchQueryHbaseExecutorService！" + i);

                        batchQueryHbaseExecutorService.submit(new Runnable() {
                            @Override
                            public void run() {
                                int n = 0;
                                for(int k = 0; k < 3000000; k++){
                                    n += k;
                                }
                                System.out.println(Thread.currentThread().getId() + ": 正在执行!");
                            }
                        });
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}
