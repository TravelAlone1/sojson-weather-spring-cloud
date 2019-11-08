package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/11/6 21:21
 */

import com.lx.weather.service.DataClient;
import com.lx.weather.service.WeatherReportService;
import com.lx.weather.vo.City;
import com.lx.weather.vo.Weather;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: sojson-weather-spring-cloud
 *
 * @author: lx
 *
 * @create: 2019-11-06 21:21
 **/
@Controller
@Log
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private DataClient dataClient;

    @Autowired
    private WeatherReportService weatherReportService;


    @GetMapping("/list")
    @ResponseBody
    public List<City> list(){
        return dataClient.getCity();
    }


    @GetMapping("/{cityId}")
    @ResponseBody
    public Weather getWeather(@PathVariable("cityId") String cityId){
        return weatherReportService.getDataByCityId(cityId);
    }

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId){
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("weather/report");
        view.addObject("title","凌霄的天气预报");
        view.addObject("cityId",cityId);
        //view.addObject("cityList",cityDataService.listCity());
        List<City> cities = dataClient.getCity();
        System.out.println(cities);
        System.out.println(cities.toString());
        for (City city: cities){
            view.addObject("cityList",city);
        }

        view.addObject("report",weatherReportService.getDataByCityId(cityId));
        return view;
    }
}
