package com.abulivyet.abuadmin.common.aspect;

import com.abulivyet.abuadmin.common.annotation.Log;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(com.abulivyet.abuadmin.common.annotation.Log)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Log logAnnotation = signature.getMethod().getAnnotation(Log.class);

        HttpServletRequest request = getHttpServletRequest();

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            // 构建日志信息
            String logMessage = String.format(
                    "接口异常 | URL: %s | Method: %s | 类方法: %s | 标题: %s | 业务类型: %s | 异常信息: %s",
                    request != null ? request.getRequestURL() : "N/A",
                    request != null ? request.getMethod() : "N/A",
                    joinPoint.getSignature().toShortString(),
                    logAnnotation.title(),
                    logAnnotation.businessType(),
                    e.getMessage()
            );

            // 打日志
            logger.error(logMessage, e);

            // 继续抛异常，让全局异常处理捕获
            throw e;
        }
    }

    private HttpServletRequest getHttpServletRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) return null;
        return ((ServletRequestAttributes) requestAttributes).getRequest();
    }
}