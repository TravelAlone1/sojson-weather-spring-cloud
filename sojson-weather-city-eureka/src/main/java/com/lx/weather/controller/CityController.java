package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/31 18:34
 */

import com.lx.weather.service.CityDataService;
import com.lx.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-31 18:34
 **/

@RestController
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/citylist")
    public List<City> cityList() throws Exception {
        List<City> cities = cityDataService.listCity();
        return cities;
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello go";
    }

}
