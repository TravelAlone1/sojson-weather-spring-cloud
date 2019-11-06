package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/28 10:38
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanOperationInfo;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-28 10:38
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model){
        return "天气预报";
    }

}