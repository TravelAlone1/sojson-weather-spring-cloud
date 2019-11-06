package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/15 11:10
 */

import com.lx.weather.global.Result;
import com.lx.weather.global.ResultCode;
import com.lx.weather.service.WeatherDataService;
import com.lx.weather.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: weather
 *
 * @author: lx
 *
 * @create: 2019-10-15 11:10
 **/
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherDataService weatherDataService;

//    @GetMapping("cityId/{cityId}")
//    public Result getWeatherByCityId(@PathVariable("cityId") String cityId){
//        Weather data= weatherDataService.getDataByCityId(cityId);
//        Result result = new Result(ResultCode.SUCCESS, data);
//        return result;
//    }
    @GetMapping("cityId/{cityId}")
    public Weather getWeatherByCityId(@PathVariable("cityId") String cityId){
        return  weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("cityName/{cityName}")
    public Weather getWeatherByCityName(@PathVariable("cityName") String cityName){
        Weather dataByCityName = weatherDataService.getDataByCityName(cityName);
        return dataByCityName;
    }


}
