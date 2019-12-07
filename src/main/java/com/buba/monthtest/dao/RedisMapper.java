package com.buba.monthtest.dao;

import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.Set;

/**
 * @ClassName RedisMapper
 * @Description TODO
 * @Author Chang
 * @Date 2019/4/29 9:00
 * @Version 1.0
 **/
public interface RedisMapper {
    public String set(String key, String value);
    public String get(String key);
    public String hget(String key, String field);
    public Long hset(String key, String field, String value);
    public Boolean hexists(String key, String filed);
    public void hdel(String key, String filed);
    public Set<String> hkeys(String key);
    public void incr(String key);
    public void lpush(String id, String goodsId);
    public List<String> lrange(String id);
    public void rpop(String id);
    public void lrem(String id, String goodsId);
    public void expire(String id, int miao);
    public Long llen(String id);

    public Transaction multi();
    public  String watch(String key);
}
