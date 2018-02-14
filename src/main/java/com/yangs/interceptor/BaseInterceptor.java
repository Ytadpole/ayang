package com.yangs.interceptor;

import com.yangs.utils.Commons;
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

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("");
        log.info("start--------------");
        String uri = httpServletRequest.getRequestURI();
        log.info("user-agent:{}", httpServletRequest.getHeader("user-agent"));
        log.info("用户访问地址:{}", uri);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        httpServletRequest.setAttribute("commons", commons);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("end--------------");
        log.info("");
    }
}
