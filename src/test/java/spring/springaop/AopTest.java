package spring.springaop;

import com.sheng.springaop.LoginService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zzs .
 * @since 2019/5/31
 */
public class AopTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:aop-annotation.xml");
        LoginService loginService = (LoginService) applicationContext.getBean("loginService");
        loginService.login("sdf");
    }
}
