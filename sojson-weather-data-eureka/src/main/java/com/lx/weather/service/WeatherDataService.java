package com.lx.weather.service;


import com.lx.weather.vo.Weather;

/**
 * @Author: lx
 * @Date: 2019/10/14 18:27
 */

public interface WeatherDataService {

    Weather getDataByCityId(String cityId);

    Weather getDataByCityName(String cityName);


}
