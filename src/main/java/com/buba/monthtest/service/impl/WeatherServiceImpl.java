package com.buba.monthtest.service.impl;

import com.buba.monthtest.dao.WeatherMapper;
import com.buba.monthtest.pojo.Weather;
import com.buba.monthtest.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author Chang
 * @Date 2019/9/23 15:41
 * @Version 1.0
 **/
@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    WeatherMapper weatherMapper;

    @Override
    public boolean addWeather(Weather weather1) {
        boolean  b=weatherMapper.addWeather(weather1);
        return b;
    }
}
