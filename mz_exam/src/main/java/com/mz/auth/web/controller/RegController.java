package com.mz.auth.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @description: 响应注册相关的业务请求
 */
@Controller
public class RegController {
    /**
     *   跳转到注册页面
     *   /gotoReg 是前端访问后端的请求路径
     *   views/reg  是服务器内部静态资源的转发
     */
    @RequestMapping("/gotoReg")
    public String gotoReg(){
        return "views/reg";
    }
}
