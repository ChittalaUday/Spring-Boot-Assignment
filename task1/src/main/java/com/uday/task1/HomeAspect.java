package com.uday.task1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HomeAspect {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(HomeAspect.class);

    @Pointcut("execution(* com.uday.task1.Task1Application.home(..))")
    public void homeMethod() {
    }

    @Around("homeMethod()")
    public void homeAround(ProceedingJoinPoint pf) {
        logger.info("Before executing home method");
        Object data;
        try {
            data = pf.proceed();
            logger.info("Successfully executed home method");
            logger.info("Response from home method: " + data);
            logger.info("After returning from home method");
        } catch (Throwable e) {
            logger.error("Exception in home method: " + e.getMessage());
        } finally {
            logger.info("Method execution completed");
        }
    }
}
