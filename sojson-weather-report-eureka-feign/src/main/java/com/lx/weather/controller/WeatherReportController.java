package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/24 18:40
 */

import com.lx.weather.service.CityClient;
import com.lx.weather.service.WeatherDataClient;
import com.lx.weather.service.WeatherReportService;
import com.lx.weather.vo.City;
import com.lx.weather.vo.Weather;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-24 18:40
 **/

@Controller
@Log
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityClient cityClient;


    @GetMapping("cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId){
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("weather/report");
        view.addObject("title","凌霄的天气预报");
        view.addObject("cityId",cityId);
        //view.addObject("cityList",cityDataService.listCity());
        List<City> cities = cityClient.getCity();
        for (City city: cities){
            view.addObject("cityList",city);
        }
        view.addObject("report",weatherReportService.getDataByCityId(cityId));
        return view;
    }
}
