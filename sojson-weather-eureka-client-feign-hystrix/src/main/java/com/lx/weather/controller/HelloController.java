package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/11/5 20:42
 */

import com.lx.weather.service.EurekaCclientService;
import com.lx.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-05 20:42
 **/
@RestController
@RequestMapping
public class HelloController {

    //@Qualifier("sojson-weather-city-eureka")
    @Autowired
    private EurekaCclientService eurekaCclientService;

//    @GetMapping("/hello")
//    public List<City> lsit(){
//        return eurekaCclientService.list();
//    }

    @GetMapping("/hello")
    public String hello(String name){
        return eurekaCclientService.hello(name);
    }

    @GetMapping("/index")
    public String index(){
        return "spring boot +++++++";
    }
}
