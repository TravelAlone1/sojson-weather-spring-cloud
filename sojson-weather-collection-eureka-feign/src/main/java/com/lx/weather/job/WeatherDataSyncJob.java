package com.lx.weather.job;/**
 * @Author: lx
 * @Date: 2019/10/16 21:55
 */

import com.google.common.base.Strings;
import com.lx.weather.service.CityClient;
import com.lx.weather.service.WeatherDataCollectionService;
import com.lx.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @program: sojson-weather
 * @author: lx
 * @create: 2019-10-16 21:55
 **/
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    private Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("++++++++++++++++++=");
        logger.info("Weather Data Sync Job");
        List<City> cityList = null;
        try {
            cityList = cityClient.getCity();
        } catch (Exception e) {
            logger.error("Exception!" + e);
        }
        assert cityList != null;
        for (City city : cityList) {

            //String cityId = city.getCityCode();
            if (!Strings.isNullOrEmpty(city.getCityCode())) {

                logger.info("Weather Data Sync Job" + city.getCityCode());
                weatherDataCollectionService.syncDataByCityId(city.getCityCode());
                try {
                    Thread.sleep(1000 * 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
