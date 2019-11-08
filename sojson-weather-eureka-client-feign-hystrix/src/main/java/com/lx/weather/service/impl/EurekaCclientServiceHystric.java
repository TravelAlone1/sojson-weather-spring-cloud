package com.lx.weather.service.impl;/**
 * @Author: lx
 * @Date: 2019/11/5 18:49
 */

import com.lx.weather.service.EurekaCclientService;
import com.lx.weather.vo.City;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-05 18:49
 **/
@Component
public class EurekaCclientServiceHystric implements EurekaCclientService  {
//    @Override
//    public List<City> list() {
//        return null;
//    }

    public String defaultcities(){
        return "city data is down!";
    }

    @Override
    public String hello(String name) {
        return "调用sojson-weather-city-eureka服务异常:调用" + name;
    }
}
