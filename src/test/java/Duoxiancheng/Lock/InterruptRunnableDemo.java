package Duoxiancheng.Lock;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

import java.util.concurrent.atomic.AtomicInteger;

public class InterruptRunnableDemo extends Thread {

    static FastThreadLocal<String> threadLocal = new FastThreadLocal<String>() {
        @Override
        protected String initialValue() throws Exception {
            return "zero";
        }
    };

    public static void main(String[] args) {
        FastThreadLocalThread thread0 = new FastThreadLocalThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        });
        FastThreadLocalThread thread1 = new FastThreadLocalThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(threadLocal.get());
            }
        });
        thread0.start();
        thread1.start();
    }
}
