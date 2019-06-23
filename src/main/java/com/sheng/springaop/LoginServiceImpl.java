package com.sheng.springaop;

/**
 * @author zzs .
 * @since 2019/5/31
 */
public class LoginServiceImpl implements LoginService {

    @UseAop
    @Override
    public String login(String userName) {
        System.out.println("正在登录");
        return "success";
    }
}
