//package com.sheng.commons.exception;
//
//import lombok.Data;
//
///**
// * @author luokai
// */
//@Data
//public class ServiceException extends RuntimeException {
//    private String code;
//
//    public ServiceException(String code, String msg, Exception e) {
//        super(msg, e);
//        this.code = code;
//    }
//
//    public ServiceException(String msg) {
//        super(msg);
//        this.code = "500";
//    }
//
//    public ServiceException(String code, String msg) {
//        super(msg);
//        this.code = code;
//    }
//}
