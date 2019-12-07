package com.pkgs.util;

import org.springframework.context.ApplicationContext;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 20:37
 * <p>
 * @since 1.0.0
 */
public class CtxUtil {

    private static ApplicationContext context;


    public static void setContext(ApplicationContext ctx) {
        context = ctx;
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
