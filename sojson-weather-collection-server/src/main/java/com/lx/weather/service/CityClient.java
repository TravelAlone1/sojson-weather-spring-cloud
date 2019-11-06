package com.lx.weather.service;

import com.lx.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/11/2 8:19
 */
@FeignClient(value = "sojson-weather-city-eureka")
public interface CityClient {


    @GetMapping("/citylist")
    List<City> listcity();
}
