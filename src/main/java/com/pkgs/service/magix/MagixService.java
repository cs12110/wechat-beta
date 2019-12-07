package com.pkgs.service.magix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 22:40
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Service
public class MagixService {

    @Value("${magix.mr3306.openId}")
    private String openId;


    public void sendMessage(String message){

    }
}
