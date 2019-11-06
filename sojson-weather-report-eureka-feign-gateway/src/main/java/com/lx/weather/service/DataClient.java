package com.lx.weather.service;

import com.lx.weather.vo.City;
import com.lx.weather.vo.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/11/4 10:31
 */
@FeignClient("sojson-weather-eureka-client-zuul")
public interface DataClient {

    /**
     * 获取城市列表
     * @return
     */
    @GetMapping("/city/citylist")
    public List<City> getCity();


    @GetMapping("/data/weather/cityId/{cityId}")
    Weather getWeatherByCityId(@PathVariable("cityId") String cityId);

}
