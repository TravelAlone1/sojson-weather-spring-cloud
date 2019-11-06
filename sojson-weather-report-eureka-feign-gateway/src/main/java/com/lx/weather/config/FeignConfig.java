package com.lx.weather.config;/**
 * @Author: lx
 * @Date: 2019/11/2 8:22
 */

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-11-02 08:22
 **/
@Configuration
public class FeignConfig {

    /**
     * 建立socket超时时间，读取响应socket超时时间
     * @return
     */
    @Bean
    public Request.Options CityClient(){
        return new Request.Options(120000,120000);
    }

    /**
     * 自定义重试次数
     * @return
     */
    @Bean
    public Retryer feignRetried(){
        return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L),5);
    }

}
