package com.yangs.controller;

/**
 * Created by Ytadpole on 2018/2/14.
 */
public abstract class BaseController {
    private static final String THEME = "themes/default/";

    /**
     * 后期可以分主题用
     * @param viewName
     * @return
     */
    public String renderer(String viewName){
        return THEME + viewName;
    }
}
