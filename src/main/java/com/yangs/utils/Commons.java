package com.yangs.utils;

import com.yangs.config.DefaultConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * page tools
 * Created by Ytadpole on 2018/2/14.
 */
@Component
public final class Commons {
    /**
     * sit option
     * @param keyword
     * @return
     */
    public static String site_option(String keyword){
       return site_option(keyword, null);
    }

    /**
     * sit options
     * @param keyword
     * @param defaultVal
     * @return
     */
    public static String site_option(String keyword, String defaultVal){
        if(StringUtils.isEmpty(keyword)){
            return "";
        }

        if(StringUtils.isEmpty(DefaultConfig.defaultConfig.get(keyword))){
            if(StringUtils.isEmpty(defaultVal)){
                return "";
            }else{
                return defaultVal;
            }
        }else {
            return DefaultConfig.defaultConfig.get(keyword);
        }
    }

    public static String site_url(String url)
}
