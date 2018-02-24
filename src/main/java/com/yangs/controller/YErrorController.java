package com.yangs.controller;

/**
 * Created by Ytadpole on 2018/2/24.
 */
public class YErrorController extends BaseController implements org.springframework.boot.autoconfigure.web.ErrorController{
    @Override
    public String getErrorPath() {
        return null;
    }
}
