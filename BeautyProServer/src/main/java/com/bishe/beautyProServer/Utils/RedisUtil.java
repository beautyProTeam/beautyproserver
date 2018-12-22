package com.bishe.beautyProServer.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	public static void getConnection() {
		//获取连接池的配置对象
		JedisPoolConfig jpc=new JedisPoolConfig();
		//设置最大连接数
		jpc.setMaxTotal(30);
        //设置最大空闲连接数
		jpc.setMaxIdle(10);
        //获取连接池
        JedisPool jedisPool = new JedisPool(jpc,"127.0.0.1", 6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        if(jedis!=null) {
        	jedis.close();
        }
        if(jedisPool!=null) {
        	jedisPool.close();
        }
	}
}
