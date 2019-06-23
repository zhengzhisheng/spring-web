package com.sheng.Lock;

/**
 * @author zzs .
 * @since 2019/6/20
 */
public class Thread1 implements Runnable{

    @Override
    public void run() {
//		SynchronizedTest s = SynchronizedTest.getInstance();
//		s.method1();
//		SynchronizedTest s1 = new SynchronizedTest();
//		s1.method1();
        SynchronizedTest.staticIn.method1();

//		SynchronizedTest.staticMethod1();
//		SynchronizedTest.staticMethod2();
    }
}

