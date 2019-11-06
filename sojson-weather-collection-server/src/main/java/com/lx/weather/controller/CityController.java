package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/11/2 9:27
 */

import com.lx.weather.service.CityClient;
import com.lx.weather.vo.City;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-02 09:27
 **/
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    public List<City> cityList(){
        //通过Feign客户端来查找
        List<City> body=cityClient.listcity();
        return body;
    }
}