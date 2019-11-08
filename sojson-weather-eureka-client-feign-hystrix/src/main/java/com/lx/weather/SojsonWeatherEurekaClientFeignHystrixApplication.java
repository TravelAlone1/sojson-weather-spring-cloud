package com.lx.weather;

import com.lx.weather.service.EurekaCclientService;
import com.lx.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ComponentScan(basePackages = {"com.lx.weather.*"})
@SpringBootApplication//(scanBasePackages = "com.lx.weather.service.impl")
@EnableDiscoveryClient
@EnableFeignClients
public class SojsonWeatherEurekaClientFeignHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(SojsonWeatherEurekaClientFeignHystrixApplication.class, args);
    }


}
