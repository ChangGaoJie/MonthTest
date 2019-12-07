package com.buba.monthtest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.buba.monthtest.pojo.Book;
import com.buba.monthtest.pojo.Weather;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chang
 * @since 2019-08-26
 */
@Repository
public interface WeatherMapper{

    boolean addWeather(Weather weather1);
}
