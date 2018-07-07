//package com.sheng.commons.enhance.interceptor;
//
//import com.souche.optimus.common.util.CommonUtil;
//import com.souche.sso.client2.util.HttpSecurityUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by luokai on 16/8/24.
// */
//@Slf4j
//public class ApiInterceptor extends HandlerInterceptorAdapter {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        String userAgent = request.getHeader("User-Agent");
//        String appName = request.getHeader("AppName");
//        String appVersion = request.getHeader("AppVersion");
//        String host = request.getHeader("host");
//
//        StringBuffer sb = new StringBuffer();
//        //共具体的数据可以看链路监控
//        sb.append("request url:" + CommonUtil.getRequestUrl(request, true)).append("\r\n")
//                .append("token:" + HttpSecurityUtil.getSid(request)).append(" ,refer: " + request.getHeader("referer")).append(" ,host" + host).append("\r\n")
//                .append("userAgent=" + userAgent + ",appName" + appName + ",appVersion=" + appVersion).append(" ,ip :" + CommonUtil.getRemoteIpAddress(request));
//        log.info(sb.toString());
//
//        return true;
//    }
//}
