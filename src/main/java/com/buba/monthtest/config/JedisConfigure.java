package com.buba.monthtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName JedisConfigure
 * @Description TODO
 * @Author Chang
 * @Date 2019/10/29 10:44
 * @Version 1.0
 **/
@SpringBootConfiguration
@PropertySource(value = "classpath:redisConfig.properties")
public class JedisConfigure {
    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;

    @Bean
    public JedisPool jedisPool(){

            return new JedisPool(host,port);
    }


}
