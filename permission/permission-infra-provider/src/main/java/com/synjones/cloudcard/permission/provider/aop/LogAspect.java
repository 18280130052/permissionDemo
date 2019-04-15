package com.synjones.cloudcard.permission.provider.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

    private  final Logger logger = LoggerFactory.getLogger(getClass());

    /*接入点*/
    private final String POINT_CUT = "execution(* com.synjones.cloudcard.per..*(..))";

    //@Pointcut("@annotation(com.synjones.cloudcard.*.*Provider)")
    @Pointcut(POINT_CUT)
    public void providerPointCut() {

    }

    @Around("providerPointCut()")
    public Object doAround(JoinPoint jp){
        return null;
    }
}
