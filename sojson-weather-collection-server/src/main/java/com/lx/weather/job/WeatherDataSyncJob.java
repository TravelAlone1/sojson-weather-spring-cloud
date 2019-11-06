package com.lx.weather.job;/**
 * @Author: lx
 * @Date: 2019/10/16 21:55
 */

import com.google.common.base.Strings;

import com.lx.weather.service.CityClient;
import com.lx.weather.service.WeatherDataCollectionService;
import com.lx.weather.vo.City;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: sojson-weather
 *
 * @author: lx
 *
 * @create: 2019-10-16 21:55
 **/
public class WeatherDataSyncJob extends QuartzJobBean {


    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    private Logger logger= LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Weather Data Sync Job");

        //TODO 改为由城市数据API微服务来提供数据
        List<City> cityList=null;

        try {

            cityList=cityClient.listcity();
            System.out.println(cityList.toString());
        } catch (Exception e) {
            logger.error("Exception!" + e);
        }
        //assert cityList != null;
        for (City city: cityList){
            String cityId=city.getCityCode();
            if (!Strings.isNullOrEmpty(cityId)){

                logger.info("Weather Data Sync Job"+cityId);
                weatherDataCollectionService.syncDataByCityId(cityId);
                try {
                    Thread.sleep(1000*20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
