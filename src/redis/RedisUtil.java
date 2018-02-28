package redis;

import redis.clients.jedis.Jedis;

public class RedisUtil {
	public static void main(String[] args) {
		Jedis jredis=RedisPool.getJedis();
		jredis.lpush("list", "aa","bb");
		jredis.lpush("list", "cc","dd");
		int i=7;
		while(i-->0){
			System.out.println(jredis.lpop("list"));
			}
		
	}
}
