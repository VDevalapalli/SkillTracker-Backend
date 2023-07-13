package com.iiht.fse4.skilltracker.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnExpression("${aop.aspect.method.exe.time.enabled:true}")
@Slf4j
public class ElapsedTimeAspect {
    @Around("@annotation(com.iiht.fse4.skilltracker.common.aspect.TrackElapsedTime)")
    public Object executionTime(ProceedingJoinPoint point) throws Throwable {
        Object object = null;
        long startTime = System.currentTimeMillis();
        try {
            object = point.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            log.info("Class Name: " + point.getSignature().getDeclaringTypeName() + ". Method Name: " + point.getSignature().getName() + ". Time taken for Execution is : " + (endTime - startTime) + "ms");
        }
        return object;
    }
}
