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
        //JedisPool jedisPool = new JedisPool(jpc,"127.0.0.1", 6379);
		//JedisPool jedisPool = new JedisPool(jpc,"172.17.0.16", 6379);
		/*JedisPool jedisPool = new JedisPool(jpc,"118.25.130.225", 6379);*/
		JedisPool jedisPool = new JedisPool(jpc, "118.25.130.225", 6379, 30000, "123456");
        //获取连接
        Jedis jedis = jedisPool.getResource();
        String str = jedis.hget("USER", "82");
        System.out.println(str);
        if(jedis!=null) {
        	jedis.close();
        }
        if(jedisPool!=null) {
        	jedisPool.close();
        }
	}
	public static void main(String[] args) {
		getConnection();
	}
}
