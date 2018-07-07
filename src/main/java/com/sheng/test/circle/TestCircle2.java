package com.sheng.test.circle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zzs .
 * @since 2018/5/29
 */
public class TestCircle2 {

    private final static ClassPathXmlApplicationContext moduleContext;
    private static Test test;
    static {
        moduleContext = new ClassPathXmlApplicationContext(new String[]{"beans-circile.xml"},false);
        moduleContext.setAllowCircularReferences(false);
        test = (Test) moduleContext.getBean("test");
    }


    public static void main(String[] args)  {

        System.out.println(test.name);
    }
}