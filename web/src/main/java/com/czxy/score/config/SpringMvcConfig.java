package com.czxy.score.config;

import com.czxy.score.intercept.MyIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private MyIntercept myIntercept;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myIntercept).addPathPatterns("/**");
    }
}
