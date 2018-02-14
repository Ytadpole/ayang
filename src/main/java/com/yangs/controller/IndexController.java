package com.yangs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ytadpole on 2018/2/14.
 */
@Controller
public class IndexController extends BaseController{
    @GetMapping(value = {"/", "index"})
    public String index(HttpServletRequest request){
        return this.renderer("index");
    }


}
