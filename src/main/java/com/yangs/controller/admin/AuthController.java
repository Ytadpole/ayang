package com.yangs.controller.admin;

import com.yangs.controller.BaseController;
import com.yangs.modal.bo.RestResponseBo;
import com.yangs.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ytadpole on 2018/2/23.
 */
@Controller
@RequestMapping(value = "/admin")
public class AuthController extends BaseController{
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Resource
    private IUserService userService;

    @GetMapping(value = {"/login"})
    public String logIn(HttpServletRequest httpServletRequest){
        return this.adminRenderer("login");
    }

    @PostMapping(value = "/doLogin" )
    @ResponseBody
    public RestResponseBo doLogIn(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam(required = false) String remeber_me,
                          HttpServletRequest httpServletRequest,
                          HttpServletResponse httpServletResponse){
        userService.login(username, password);
        RestResponseBo b = RestResponseBo.ok();
        return b;
    }
}
