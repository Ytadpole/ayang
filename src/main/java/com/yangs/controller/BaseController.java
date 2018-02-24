package com.yangs.controller;


/**
 * Created by Ytadpole on 2018/2/14.
 */
public abstract class BaseController {
    private static final String THEME = "themes/default/";
    private static final String ADMIN_THEME = "admin/";
    private static final String COMMON_THEME = "comm/";

    /**
     * 后期可以分主题用
     * @param viewName html名 不带后缀
     * @return
     */
    public String renderer(String viewName){
        return THEME + viewName;
    }

    public String adminRenderer(String viewName){
        return ADMIN_THEME + viewName;
    }

    public String commonRenderer(String viewName){
        return COMMON_THEME + viewName;
    }
}
