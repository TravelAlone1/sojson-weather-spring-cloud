package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/11/4 18:55
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-04 18:55
 **/
@Controller
@RequestMapping("/hello1")
public class HelloController {

    @ResponseBody
    @GetMapping("index")
    public String index(){
        return "hello";
    }
}
