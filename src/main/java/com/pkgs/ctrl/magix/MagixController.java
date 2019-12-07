package com.pkgs.ctrl.magix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 22:38
 * <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/magix/")
public class MagixController {

    @RequestMapping("/sendMessage")
    @ResponseBody
    public  String sendMessage(String message){
        return "";
    }
}
