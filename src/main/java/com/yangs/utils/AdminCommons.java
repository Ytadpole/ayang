package com.yangs.utils;

import org.springframework.stereotype.Component;

/**
 * Created by Ytadpole on 2018/2/23.
 * 后台前端交互
 */
@Component
public class AdminCommons {
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

    /**
     * 头像展示 目前简单点
     * @return
     */
    public static String gravatar(){
        return "/admin/images/head.jpg";
    }
}
