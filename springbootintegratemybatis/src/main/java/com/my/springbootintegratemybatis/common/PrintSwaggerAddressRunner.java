package com.my.springbootintegratemybatis.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class PrintSwaggerAddressRunner implements ApplicationRunner {

    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String swaggerUrl = "swagger url: http://localhost:" + serverPort + "/swagger-ui.html";
        System.err.println(swaggerUrl);
    }
}