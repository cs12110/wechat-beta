package com.pkgs.service.wechat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pkgs.util.HttpUtil;
import com.pkgs.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 21:47
 * <p>
 * @since 1.0.0
 */
@Service
@Slf4j
public class WechatTokenService {

    @Value("${wechat.app.id}")
    private String appId;

    @Value("${wechat.app.secret}")
    private String secret;

    @Value("${wechat.app.token.url}")
    private String tokenUrl;


    private static String token = null;

    /**
     * 获取token
     *
     * @return token
     */
    public String getToken() {
        if (StrUtil.isEmpty(token)) {
            refreshToken();
        }
        return token;
    }


    public void refreshToken() {
        HttpClientBuilder clientBuilder = HttpClientBuilder.create();
        CloseableHttpClient httpClient = clientBuilder.build();
        try {
            HttpGet request = new HttpGet(tokenUrl);
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity httpEntity = response.getEntity();
            InputStream content = httpEntity.getContent();

            //{"access_token":"28_v_eQ_6a_5qId_ql4yV_8Q79RpNUqxjDWXX2N_aD_f9iBQH0ks6Ll5lTqL_u7Y6mYcv5xc7zjRH5a-5h5vmliHIxQMRj9qT3uqYnWdfFTIfLZLVt2W6hYlDEz6-MAgthYa7AfVFE76CX51GEIKLGbAJAEFA","expires_in":7200}
            String text = HttpUtil.try2Read(content);
            log.info("refreshToken,value:{}", text);

            JSONObject jsonObject = JSON.parseObject(text);
            token = jsonObject.getString("access_token");
        } catch (Exception e) {
            log.error("refreshToken", e);
        } finally {
            try {
                httpClient.close();
            } catch (Exception e1) {
                //do nothing
            }
        }
    }

}
