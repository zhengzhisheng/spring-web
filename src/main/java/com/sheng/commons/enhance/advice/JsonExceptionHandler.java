//package com.sheng.commons.enhance.advice;
//
//import com.souche.finance.supply.common.exception.ParamValidException;
//import com.souche.finance.supply.common.exception.ServiceException;
//import com.souche.optimus.core.exception.DefaultExceptionHandler;
//import com.souche.optimus.core.web.Result;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * 全部捕获异常
// *
// * Created by luokai on 2017/11/17.
// */
//@Component
//@Slf4j
//public class JsonExceptionHandler extends DefaultExceptionHandler {
//
//    @Override
//    public Result<Object> handleException(HttpServletRequest request, Throwable e)
//            throws Throwable {
//
//        if (e instanceof ServiceException) {
//            Result res = genErrorInfo(500, ((ServiceException)e).getCode(), e.getMessage());
//            log.error(e.getMessage(), e);
//            return res;
//        }
//        if (e instanceof IllegalArgumentException) {
//            Result res = genErrorInfo(500, "ILLEGAL_ARGUMENT", e.getMessage());
//            log.error(e.getMessage(), e);
//            return res;
//        }
//
//        //参数校验异常
//        if (e instanceof ParamValidException) {
//            Result ret = new Result();
//            ret.setSuccess(false);
//            ret.setCode("400");
//            ErrorInfo errorInfo = new ErrorInfo();
//            errorInfo.setErrCode("INVALID_ARGUMENT_ERROR");
//            errorInfo.setMessage(((ParamValidException) e).getFieldErrors().toString());
//            ret.setMsg("invalid params");
//            ret.setData(errorInfo);
//            log.error(e.getMessage(), e);
//            return ret;
//        }
//
//        String requestUrl = "requestUrl: ";
//        if (request != null) {
//            requestUrl = request.getRequestURI();
//        }
//
//        log.error(requestUrl + ", errorMsg: " + e.getMessage(), e);
//        Result res = genErrorInfo(500, "INTERNAL_SERVER_ERROR", "系统异常");
//        return res;
//    }
//
//    private Result genErrorInfo(int code, String errCode, String message) {
//        if (errCode == null) {
//            errCode = "SERVICE_EXCEPTION";
//        }
//        ErrorInfo errorInfo = new ErrorInfo();
//        errorInfo.setErrCode(errCode);
//        if (StringUtils.isBlank(message)) {
//            message = "系统异常";
//        }
//        errorInfo.setMessage(message);
//        Result res = new Result();
//        res.setSuccess(false);
//        res.setCode(code + "");
//        res.setData(errorInfo);
//        res.setMsg(message);
//        return res;
//    }
//
//    @Data
//    private static class ErrorInfo {
//        private String errCode;
//        private String message;
//    }
//}
