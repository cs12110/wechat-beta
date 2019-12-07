package com.pkgs;

import com.pkgs.util.CtxUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 20:35
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        CtxUtil.setContext(context);
    }

}
