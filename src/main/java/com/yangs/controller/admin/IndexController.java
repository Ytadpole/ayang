package com.yangs.controller.admin;

import com.yangs.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Ytadpole on 2018/2/23.
 */
//和前端indexController区别
@Controller("AdminIndexController")
@RequestMapping(value = "/admin")
public class IndexController extends BaseController{
    @GetMapping(value = {"", "index"})
    public String index(HttpServletRequest httpServletRequest){
        return this.adminRenderer("index");
    }

}
