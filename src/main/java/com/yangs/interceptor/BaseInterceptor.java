package com.yangs.interceptor;

import com.yangs.modal.vo.UserVo;
import com.yangs.utils.AdminCommons;
import com.yangs.utils.Commons;
import com.yangs.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ytadpole on 2018/2/14.
 */
@Component
public class BaseInterceptor implements HandlerInterceptor{
    private static Logger log = LoggerFactory.getLogger(BaseInterceptor.class);

    @Resource
    private Commons commons;

    @Resource
    private AdminCommons adminCommons;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("");
        log.info("start--------------");

        //一些请求信息打印
        String uri = httpServletRequest.getRequestURI();
        log.info("user-agent:{}， ip:{}", httpServletRequest.getHeader("user-agent"), IPUtil.getIpAddress(httpServletRequest));
        log.info("用户访问地址:{}", uri);

        //后台用户登录缓冲判断
        //是后台请求，且没指定为login
        if(uri.startsWith("/admin") && !uri.startsWith("/admin/login")){
            UserVo userVo = null;// TODO: 2018/2/23 查询用户回话
            /*if( null == userVo){
                //无用户信息 未登录或回话超时
                httpServletResponse.sendRedirect("/admin/login");
                return false;
            }else{

            }*/
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("prepare start...");
        httpServletRequest.setAttribute("commons", commons);
        httpServletRequest.setAttribute("adminCommons", adminCommons);
        log.info("prepare end...");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("end--------------");
        log.info("");
    }
}
