package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/28 10:38
 */

import com.lx.weather.service.CityClient;
import com.lx.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-28 10:38
 **/
@RestController
public class HelloController {

    @Autowired
    private CityClient cityClient;

    @RequestMapping("/hello")
    public String hello(Model model){
        return "天气预报";
    }

    @GetMapping("/city")
    public List<City> getcity(){
        return cityClient.getCity();
    }

}