package com.lx.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.lx.weather.*"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SojsonWeatherReportEurekaFeignGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SojsonWeatherReportEurekaFeignGatewayApplication.class, args);
    }

}
