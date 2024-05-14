package com.swontech.s05.config;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("within(com.swontech.s05.service.controller..*.*)")
    public void onRequest() {

    }

    @Around("com.swontech.s05.config.LogAspect.onRequest()")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Map<String, String[]> paramMap = request.getParameterMap();
        String params = "";
        if(!paramMap.isEmpty()) {
            params = "[" + paramMapToString(paramMap) + "]";
        }

        long start = System.currentTimeMillis();
        try {
            return pjp.proceed(pjp.getArgs());
        } finally {
            long end = System.currentTimeMillis();
            log.info("**************************************************************************************************************");
            log.info("* Request Method     : {}", request.getMethod());
            log.info("* Request URI        : {}", request.getRequestURI());
            log.info("* Request Params     : {}", params);
            log.info("* Time Taken         : {}ms", end - start);
            log.info("**************************************************************************************************************");
        }
    }

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s: %s", entry.getKey(), Joiner.on(",").join(entry.getValue())))
                .collect(Collectors.joining(", "));
    }
}
