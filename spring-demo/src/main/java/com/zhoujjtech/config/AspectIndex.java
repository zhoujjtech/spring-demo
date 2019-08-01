package com.zhoujjtech.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectIndex {

    @Pointcut("execution(* com.zhoujjtech.service.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void process(){
        System.out.println("process......");
    }
}
