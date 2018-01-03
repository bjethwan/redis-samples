package sample2;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Main {
	public static void main(String[] args) {

		JedisPool pool = new JedisPool(
				new JedisPoolConfig(), 
				"ec2-34-239-185-146.compute-1.amazonaws.com");
		
		try (Jedis jedis = pool.getResource()) {
			 
			  jedis.set("foo", "bar");
			  String foobar = jedis.get("foo");
			  
			  System.out.println(foobar);
			  
			  jedis.zadd("sose", 0, "car"); 
			  jedis.zadd("sose", 0, "bike"); 
			  
			  Set<String> sose = jedis.zrange("sose", 0, -1);
			  
			  System.out.println(sose);
			}
			
			/// ... when closing your application:
			pool.close();
	}
}
