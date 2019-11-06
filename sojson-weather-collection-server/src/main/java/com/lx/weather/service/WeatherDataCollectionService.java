package com.lx.weather.service;

/**
 * @Author: lx
 * @Date: 2019/10/30 21:57
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
