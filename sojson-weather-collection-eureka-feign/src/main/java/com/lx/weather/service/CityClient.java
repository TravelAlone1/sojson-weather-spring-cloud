package com.lx.weather.service;

import com.lx.weather.vo.City;
import org.apache.catalina.LifecycleState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: lx
 * @Date: 2019/11/2 20:07
 */
@FeignClient("sojson-weather-city-eureka")
public interface CityClient {

    /**
     * 获取城市微服务的数据
     * @return
     */
    @GetMapping("/citylist")//对应微服务接口访问路径
    List<City> getCity();
}
