package com.my.springbootintegratemybatis.controller;

import com.my.springbootintegratemybatis.model.Hello;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello", method = {RequestMethod.GET})
@Api(tags = "Hello")
public class HelloController {
    @RequestMapping(value = {"/sayHello/{name}"})
    @ApiOperation(value = "sayHello")
    public Hello sayHello(@PathVariable("name") String name) {
        Hello hello = new Hello();
        hello.setMessage("你好!");
        hello.setName(name);
        return hello;
    }
}
