package com.lx.weather.service.impl;/**
 * @Author: lx
 * @Date: 2019/10/24 18:24
 */


import com.lx.weather.service.DataClient;
import com.lx.weather.service.WeatherReportService;
import com.lx.weather.vo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-31 18:24
 **/
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {

        return dataClient.getWeatherByCityId(cityId);
    }
}
