package com.sheng.springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author zzs .
 * @since 2019/5/31
 */
@Aspect
public class LogBeforeLogin {

    @Pointcut("@annotation(com.sheng.springaop.UseAop)")
    public void loginMethod(){
    }

    @Before("loginMethod()")
    public void beforeLogin(){
        System.out.println("有人要登录了。。。");
    }
}
