package com.zhenghao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 可以被扫描成bean
@Controller
//@RequestMapping("/")
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

//    @RequestMapping(value = "/" ,method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        //处理请求
        //返回逻辑视图名，根据配置InternalResourceViewResolver，逻辑视图名home会被解析为/WEB-INF/views/home.jsp
        return "home";
    }
}
