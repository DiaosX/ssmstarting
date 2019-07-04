package com.my.springbootintegratemybatis.common;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfiguration {

    @Bean
    public PageHelper make() {
        PageHelper helper = new PageHelper();
        Properties prop = new Properties();
        prop.setProperty("offsetAsPageNum", "true");
        prop.setProperty("rowBoundsWithCount", "true");
        prop.setProperty("reasonable", "true");//
        helper.setProperties(prop);
        return helper;
    }
}
