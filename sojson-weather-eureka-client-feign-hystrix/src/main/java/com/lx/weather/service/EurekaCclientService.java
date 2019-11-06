package com.lx.weather.service;/**
 * @Author: lx
 * @Date: 2019/11/5 18:55
 */

import com.lx.weather.service.impl.EurekaCclientServiceHystric;
import com.lx.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-05 18:55
 **/
@FeignClient(value = "sojson-weather-city-eureka",fallback = EurekaCclientServiceHystric.class)
public interface EurekaCclientService {

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "hello") String name);

//    @GetMapping("/citylist")
//    public List<City> list();

}
