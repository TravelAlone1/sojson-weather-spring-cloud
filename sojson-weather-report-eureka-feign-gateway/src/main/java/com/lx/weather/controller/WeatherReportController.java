package com.lx.weather.controller;/**
 * @Author: lx
 * @Date: 2019/10/24 18:40
 */

import com.lx.weather.service.DataClient;
import com.lx.weather.service.WeatherReportService;
import com.lx.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;



    @GetMapping("cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId){
        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("weather/report");
        view.addObject("title","凌霄的天气预报");
        view.addObject("cityId",cityId);
        //view.addObject("cityList",cityDataService.listCity());
        List<City> cities = dataClient.getCity();
        for (City city: cities){
            view.addObject("cityList",city);
        }
        view.addObject("report",weatherReportService.getDataByCityId(cityId));
        return view;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
