package com.lx.weather.service.impl;/**
 * @Author: lx
 * @Date: 2019/11/7 11:30
 */

import com.lx.weather.service.DataClient;
import com.lx.weather.vo.City;
import com.lx.weather.vo.Weather;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sojson-weather-spring-cloud
 * @author: lx
 * @create: 2019-11-07 11:30
 **/
@Component
public class DataClientHystrix implements DataClient {

    @Override
    public List<City> getCity() {

        List<City> cityList = null;
        cityList = new ArrayList<>();
        City city = new City();
        city.setId(1);
        city.setPid(0);
        city.setCityCode("101010100");
        city.setCityName("北京");
        city.setPostCode("100000");
        city.setAreaCode("010");
        cityList.add(city);

        city = new City();
        city.setId(75);
        city.setPid(5);
        city.setCityCode("101280101");
        city.setCityName("广州");
        city.setPostCode("510000");
        city.setAreaCode("020");
        cityList.add(city);


        return cityList;
    }

    @Override
    public Weather getWeatherByCityId(String cityId) {
        return null;
    }
}
