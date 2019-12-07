package com.pkgs.ctrl.wechat;

import com.alibaba.fastjson.JSON;
import com.pkgs.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 20:42
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Controller
@RequestMapping("/wechat/station/")
public class WechatStationController {


    /**
     * wechat echo
     *
     * @param request  http request
     * @param response http response
     * @return Object
     */
    @RequestMapping("/echo")
    @ResponseBody
    public Object echo(HttpServletRequest request, HttpServletResponse response) {

        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, Object> map = new HashMap<>(5);
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            map.put(key, request.getParameter(key));
        }

        String value = HttpUtil.try2Read(request);
        log.info("echo receive map:{},value:{}", JSON.toJSONString(map),value);

        return map.get("echostr");
    }

}
