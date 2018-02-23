package com.yangs.controller;

/**
 * Created by Ytadpole on 2018/2/14.
 */
public abstract class BaseController {
    private static final String THEME = "themes/default/";

    /**
     * 后期可以分主题用
     * @param viewName html名 不带后缀
     * @return
     */
    public String renderer(String viewName){
        return THEME + viewName;
    }
}
