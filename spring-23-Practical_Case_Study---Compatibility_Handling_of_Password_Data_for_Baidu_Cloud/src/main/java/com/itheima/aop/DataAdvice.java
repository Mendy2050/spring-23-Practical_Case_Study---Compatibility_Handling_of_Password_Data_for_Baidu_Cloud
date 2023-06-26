package com.itheima.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Mendy
 * @create 2023-06-26 15:21
 */

@Component
@Aspect
public class DataAdvice {

    @Pointcut("execution(boolean com.itheima.service.*Service.*(*,*))")
    private void servicePt(){

    }


    @Around("DataAdvice.servicePt()")
    public Object trimStr(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            //check if the argument is the String type
            if(args[i].getClass().equals(String.class)){
               args[i] = args[i].toString().trim();
            }
        }

        Object ret = pjp.proceed(args);
        return ret;
    }



}
