package com.pkgs.component.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 20:41
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Aspect
@Configuration
public class ReqLogInterceptor {


    @Before("execution(* com.pkgs.ctrl..*(..))")
    public void footprint(JoinPoint joinPoint) {
        try {

            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            if (null != attributes) {
                HttpServletRequest request = attributes.getRequest();
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();

                Method method = signature.getMethod();
                String methodName =method.getDeclaringClass().getSimpleName()+"#"+method.getName();

                Map<String, Object> map = new HashMap<>(3);
                map.put("url", request.getRequestURL());
                map.put("method", request.getMethod());
                map.put("mapping", methodName);

                log.info("req:{}", JSON.toJSONString(map));
            }

        } catch (Throwable e) {
            log.error("footprint", e);
        }
    }

}
