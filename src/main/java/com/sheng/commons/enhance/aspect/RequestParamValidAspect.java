//package com.sheng.commons.enhance.aspect;
//
//import com.souche.finance.supply.common.exception.ParamValidException;
//import com.souche.finance.supply.common.vo.FieldError;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.hibernate.validator.internal.engine.path.PathImpl;
//import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
//import org.springframework.core.ParameterNameDiscoverer;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * Create by huangbingshen on 2017/11/22
// */
//@Component
//@Aspect
//@Slf4j
//public class RequestParamValidAspect {
////    @Pointcut("execution(* com.souche.finance.supply.json.*.*(..))")
//    public void controllerBefore(){}
//
//    ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
//
//    @Before("controllerBefore()")
//    public void before(JoinPoint point) throws NoSuchMethodException, SecurityException, ParamValidException {
//        //  获得切入目标对象
//        //Object target = point.getThis();
//        // 获得切入的方法
//        //Method method = ((MethodSignature)point.getSignature()).getMethod();
//        // 获得切入方法参数
//        Object [] args = point.getArgs();
//
//
//        // 执行校验，获得校验结果
//        /*Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);
//        //校验基本类型字段
//        if (!validResult.isEmpty()) {
//            String [] parameterNames = parameterNameDiscoverer.getParameterNames(method); // 获得方法的参数名称
//            List<FieldError> errors = validResult.stream().map((ConstraintViolation<Object> constraintViolation) -> {
//                PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();  // 获得校验的参数路径信息
//                int paramIndex = pathImpl.getLeafNode().getParameterIndex(); // 获得校验的参数位置
//                String paramName = parameterNames[paramIndex];  // 获得校验的参数名称
//                FieldError error = new FieldError();  // 将需要的信息包装成简单的对象，方便后面处理
//                error.setName(paramName);  // 参数名称（校验错误的参数名称）
//                error.setMessage(constraintViolation.getMessage()); // 校验的错误信息
//                return error;
//            }).collect(Collectors.toList());
//            throw new ParamValidException(errors);  // 我个人的处理方式，抛出异常，交给上层处理
//        }*/
//
//        //校验bean字段
//        for (Object bean : args) {
//            if (!ObjectUtils.isEmpty(bean)) {
//                Set<ConstraintViolation<Object>> validResult = validBeanParams(bean);
//                if (!validResult.isEmpty()) {
//                    List<FieldError> errors = validResult.stream().map(e -> {
//                        PathImpl pathImpl = (PathImpl) e.getPropertyPath();// 获得校验的参数路径信息
//                        String paramName = pathImpl.asString(); // 获得校验的参数名称
//                        FieldError error = new FieldError();  // 将需要的信息包装成简单的对象，方便后面处理
//                        error.setName(paramName);  // 参数名称（校验错误的参数名称）
//                        error.setMessage(e.getMessageTemplate()); // 校验的错误信息
//                        return error;
//                    }).collect(Collectors.toList());
//                    throw new ParamValidException(errors);  // 我个人的处理方式，抛出异常，交给上层处理
//                }
//            }
//        }
//
//    }
//
//    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//    //private final ExecutableValidator validator = factory.getValidator().forExecutables();
//    private final Validator beanValidator = factory.getValidator();
//
//    /*private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object [] params){
//        return validator.validateParameters(obj, method, params);
//    }*/
//
//    private <T> Set<ConstraintViolation<T>> validBeanParams(T bean) {
//        return beanValidator.validate(bean);
//    }
//}
