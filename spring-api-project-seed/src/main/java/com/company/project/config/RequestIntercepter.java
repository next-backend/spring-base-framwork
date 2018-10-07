package com.company.project.config;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

@Slf4j
//@Order(1)
//@Aspect
//@Component
public class RequestIntercepter {

    private static final ThreadLocal<Long> threadLocal = new ThreadLocal();

    //    @Around("execution(* org.seckill.web.*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint jp) {
        threadLocal.set(System.currentTimeMillis());
        log.info("request start :\nApi: {}, \nArgs: {}", getMethodInfo(jp), JSON.toJSONString(jp.getArgs()));
        try {
            Object obj = jp.proceed();
            long endTime = System.currentTimeMillis();
            log.info("\nResult: {}, \nduration: {}ms", JSON.toJSONString(obj), endTime - threadLocal.get());
            log.info("request end");
            return obj;
        } catch (Throwable e) {
            long endTime = System.currentTimeMillis();
            log.error("\nrequest error: \nresult : {}, \n耗时 : {}ms", e, endTime - threadLocal.get());
            log.info("request end");
        }
        return null;
    }


    private String getMethodInfo(ProceedingJoinPoint jp) {
        StringBuilder builder = new StringBuilder();
        builder.append(jp.getTarget().getClass());
        builder.append(".");
        Signature st = jp.getSignature();
        MethodSignature ms = (MethodSignature) st;
        Class[] args = ms.getParameterTypes();
        builder.append(ms.getMethod().getName())
                .append("(")
                .append(Joiner.on(",").join(args))
                .append(")");
        return builder.toString().replace("class ", "");
    }
}
