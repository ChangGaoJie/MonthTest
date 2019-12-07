package com.buba.monthtest.dao.impl;

import com.buba.monthtest.dao.RedisMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @ClassName GoodsDaoImpl
 * @Description TODO
 * @Author Chang
 * @Date 2019/4/29 10:26
 * @Version 1.0
 **/
@Service
public class redisDaoImpl implements RedisMapper {
    @Resource
    private JedisPool jedisPool;
    @Override
    public String set(String key, String value) {
        Jedis jedis=jedisPool.getResource();
        String str=jedis.set(key, value);
        jedis.close();
        return str;
    }

    @Override
    public String get(String key) {
        Jedis jedis=jedisPool.getResource();
        String str=jedis.get(key);
        jedis.close();
        return str;
    }
    @Override
    public void incr(String key) {
        Jedis jedis=jedisPool.getResource();
        jedis.incr(key);
        jedis.close();

    }


    @Override
    public String hget(String key, String field) {
        Jedis jedis=jedisPool.getResource();
        String str=jedis.hget(key,field);
        jedis.close();
        return str;
    }

    public Long hset(String key, String field, String value) {
        Jedis jedis=jedisPool.getResource();
        Long l=jedis.hset(key, field,value);
        jedis.close();
        return l;
    }

    public void lpush(String id, String goodsId) {
        Jedis jedis=jedisPool.getResource();
        jedis.lpush(id,goodsId);
        jedis.close();
    }
    public List<String> lrange(String id) {
        Jedis jedis=jedisPool.getResource();
        List<String> list=jedis.lrange(id,0,4);
        jedis.close();
        return list;
    }
    public void rpop(String id) {
        Jedis jedis=jedisPool.getResource();
        jedis.rpop(id);
        jedis.close();
    }
    public void lrem(String id, String goodsId) {
        Jedis jedis=jedisPool.getResource();
        jedis.lrem(id,+1,goodsId);
        jedis.close();
    }
    public void expire(String id,int miao) {
        Jedis jedis=jedisPool.getResource();
        jedis.expire(id,miao);
        jedis.close();
    }
    public Long llen(String id) {
        Jedis jedis=jedisPool.getResource();
        Long l=jedis.llen(id);
        jedis.close();
        return l;
    }

    public Boolean hexists(String key, String filed) {
        Jedis jedis=jedisPool.getResource();
        Boolean l=jedis.hexists(key,filed);
        jedis.close();
        return l;
    }

    public void hdel(String key, String filed) {
        Jedis jedis=jedisPool.getResource();
        jedis.hdel(key,filed);
        jedis.close();
    }

    public  Set<String> hkeys(String key) {
        Jedis jedis=jedisPool.getResource();
        Set<String> set=jedis.hkeys(key);
        jedis.close();
        return set;
    }

    public Transaction multi() {
        Jedis jedis=jedisPool.getResource();
        Transaction transaction = jedis.multi();
        jedis.close();
        return transaction;
    }
    public  String watch(String key) {
        Jedis jedis=jedisPool.getResource();
        String str=jedis.watch(key);
        jedis.close();
        return str;
    }

    public Double zscore(String key, String member) {
        Jedis jedis=jedisPool.getResource();
        Double str=jedis.zscore(key,member);
        jedis.close();
        return str;
    }
    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis=jedisPool.getResource();
        Set<String> set=jedis.zrevrange(key,start,end);
        return set;
    }

}
