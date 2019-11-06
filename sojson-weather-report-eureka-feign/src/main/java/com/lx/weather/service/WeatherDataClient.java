package com.lx.weather.service;/**
 * @Author: lx
 * @Date: 2019/11/2 20:41
 */

import com.lx.weather.vo.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-02 20:41
 **/
@FeignClient(value = "sojson-weather-data-eureka")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    Weather getWeatherByCityId(@PathVariable("cityId") String cityId);
}
