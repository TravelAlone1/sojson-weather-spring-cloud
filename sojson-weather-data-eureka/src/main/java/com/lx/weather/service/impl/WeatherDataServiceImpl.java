package com.lx.weather.service.impl;/**
 * @Author: lx
 * @Date: 2019/10/15 8:49
 */

import com.google.gson.Gson;
import com.lx.weather.service.WeatherDataService;
import com.lx.weather.vo.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * @program: weather
 * @description: WeatherDataService 的实现
 * @author: lx
 * @create: 2019-10-15 08:49
 **/
@Service
public class WeatherDataServiceImpl implements WeatherDataService {



    private static final String WEATHER_URL = "http://t.weather.sojson.com/api/weather/city/";
    private Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //使用httpClient，注入一个客户端

    @Override
    public Weather getDataByCityId(String cityId) {
        String url = WEATHER_URL + cityId;
        return doGetWeather(url, cityId);
    }

    @Override
    public Weather getDataByCityName(String cityName) {
        String url = WEATHER_URL + cityName;
        return doGetWeather(url, cityName);
    }








    public Weather doGetWeather(String url, String key) {
        String body = null;
        Weather response = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //ValueOperations ops = stringStringValueOperations
        //使用redis做缓存
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("redis has data");
            body = ops.get(key);
        } else {
            logger.info("redis don't has data");
            //缓存没有，抛出异常
            throw new RuntimeException("Don't has data");
        }
        Gson gson = new Gson();
        response = gson.fromJson(body, Weather.class);
        return response;
    }
}
