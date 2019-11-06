package com.lx.weather.service;/**
 * @Author: lx
 * @Date: 2019/10/24 18:23
 */


import com.lx.weather.vo.Weather;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-31 18:23
 **/
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气
     * @param cityId
     * @return
     */
    public Weather getDataByCityId(String cityId);
}
