package com.sheng.Lock;

/**
 * @author zzs .
 * @since 2019/6/20
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        // TODO Auto-generated method stub
//		SynchronizedTest s = SynchronizedTest.getInstance();
//		SynchronizedTest s2 = new SynchronizedTest();
//		s2.method1();
//		s.method2();
//		SynchronizedTest.staticMethod1();
//		SynchronizedTest.staticMethod2();
//		SynchronizedTest.staticIn.method2();
        SynchronizedTest.staticMethod1();
    }
}

