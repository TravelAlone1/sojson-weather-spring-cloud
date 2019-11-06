package com.lx.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class SojsonWeatherCollectionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SojsonWeatherCollectionServerApplication.class, args);
    }

}
