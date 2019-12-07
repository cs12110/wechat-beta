package com.pkgs.component.schedule;

import com.pkgs.service.wechat.WechatTokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 22:27
 * <p>
 * @since 1.0.0
 */
@Configuration
@Component
@EnableScheduling
public class RefreshTokenSchedule {

    @Resource
    private WechatTokenService wechatTokenService;


    @Scheduled(cron = "0 5 * * * ?")
    public void refresh(){
        wechatTokenService.refreshToken();
    }
}
