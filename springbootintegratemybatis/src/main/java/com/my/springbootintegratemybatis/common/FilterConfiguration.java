package com.my.springbootintegratemybatis.common;

import com.my.springbootintegratemybatis.filter.UrlCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean refererFilterRegistration() {
        FilterRegistrationBean<UrlCheckFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new UrlCheckFilter());
        //过滤规则
        registration.addUrlPatterns("/user/*");
        //过滤器名称
        registration.setName("ref");
        //过滤器顺序
        registration.setOrder(1);
        return registration;
    }
}
