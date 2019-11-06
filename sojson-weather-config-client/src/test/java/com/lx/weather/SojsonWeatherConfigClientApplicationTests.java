package com.lx.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class SojsonWeatherConfigClientApplicationTests {

    @Value("${name}")
    private String name;

    @Test
    void contextLoads() {
        assertEquals("lx",name);
    }



}
