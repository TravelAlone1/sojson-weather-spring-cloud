package com.lx.weather.service.impl;/**
 * @Author: lx
 * @Date: 2019/11/2 17:12
 */

import com.lx.weather.service.WeatherDataCollectionService;
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
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-02 17:12
 **/
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {


    private static final Long TIME_OUT = 1600L;
    private static final String WEATHER_BASE_URL = "http://t.weather.sojson.com/api/weather/city/";
    private Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    //使用httpClient，注入一个客户端
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
        String url=WEATHER_BASE_URL+cityId;
        this.saveWeatherData(url,cityId);
    }


    private void saveWeatherData(String url, String key) {
        String body = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        body = this.restTemplatebyIp(url);
        //数据写入缓存
        ops.set(key, body, TIME_OUT, TimeUnit.SECONDS);
    }

    /**
     * 使用代理Ip应对反爬
     */
    public String restTemplatebyIp(String url) {
        return getString(url, restTemplate);
    }

    static String getString(String url, RestTemplate restTemplate) {
        String body = null;
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);//无法直接获取响应对象,json字符串
        if (forEntity.getStatusCodeValue() == 200) {
            body = forEntity.getBody();
            return body;
        } else {
            SimpleClientHttpRequestFactory schrf = new SimpleClientHttpRequestFactory();
            schrf.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("106.75.212.158", 8080)));
            restTemplate.setRequestFactory(schrf);
            if (forEntity.getStatusCodeValue() == 200) {
                body = forEntity.getBody();
            }
            return body;
        }
    }
}
