package com.imooc.mumumall.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
public class WebLogAspect {

    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Pointcut("execution(public * com.imooc.mumumall.controller.*.*(..))")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("URL: " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD: " + request.getMethod());
        logger.info("IP: " + request.getRemoteAddr());
        logger.info("CLASS_METHOD: " + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(returning = "res", pointcut = "webLog()")
    public void doAfterReturning(Object res) throws JsonProcessingException {
        logger.info("RESPONSE: " + new ObjectMapper().writeValueAsString(res));
    }
}
