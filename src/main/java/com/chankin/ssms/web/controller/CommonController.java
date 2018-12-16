package com.chankin.ssms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 *  公共视图控制器
 * */
@Controller
public class CommonController {

    @RequestMapping("index")
    public String index(HttpServletRequest httpServletRequest) {
        return "index";
    }
}
