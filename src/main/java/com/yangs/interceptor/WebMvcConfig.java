package com.yangs.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created by Ytadpole on 2018/2/14.
 */
@Component
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Resource
    private BaseInterceptor baseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(baseInterceptor);
    }
}
