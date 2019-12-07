package com.pkgs.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * <p>
 *
 * @author cs12110 create at 2019-12-07 21:31
 * <p>
 * @since 1.0.0
 */
@Slf4j
public class HttpUtil {

    public static String try2Read(HttpServletRequest request) {
        try {
            try2Read(request.getInputStream());
        } catch (Exception e) {
            log.error("try2Read", e);
        }
        return null;
    }

    public static String try2Read(InputStream in) {
        StringBuilder builder = new StringBuilder();
        try {
            int len;
            byte[] arr = new byte[1024];

            while (-1 != (len = in.read(arr))) {
                builder.append(new String(arr, 0, len));
            }

            in.close();
            return builder.toString();
        } catch (Exception e) {
            log.error("try2Read", e);
        }
        return null;
    }
}
