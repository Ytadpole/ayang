package com.yangs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ytadpole on 2018/2/24.
 * 错误 处理页面
 */
@Controller
@RequestMapping(value = "/error")
public class YErrorController extends BaseController{
    @GetMapping(value = "/error404")
    public String error404(HttpServletRequest httpServletRequest){
        return this.commonRenderer("error_404");
    }

    @GetMapping(value = "/error500")
    public String error500(HttpServletRequest httpServletRequest){
        return this.commonRenderer("error_500");
    }
}
