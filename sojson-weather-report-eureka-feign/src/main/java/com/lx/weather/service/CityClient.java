package com.lx.weather.service;

import com.lx.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/11/2 20:32
 */
@FeignClient("sojson-weather-city-eureka")
public interface CityClient {

    /**
     * 对应服务的url
     * @return
     */
    @GetMapping("/citylist")
    public List<City> getCity();
}
