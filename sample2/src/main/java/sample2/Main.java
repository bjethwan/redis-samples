package sample2;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Main {
	public static void main(String[] args) {

		JedisPool pool = new JedisPool(new JedisPoolConfig(), "ec2-13-250-2-176.ap-southeast-1.compute.amazonaws.com", 6379);

		try (Jedis jedis = pool.getResource()) {

			jedis.set("foo", "bar");
			String foobar = jedis.get("foo");

			System.out.println(foobar);

			jedis.zadd("items", 0, "car"); 
			jedis.zadd("items", 0, "bike"); 

			Set<String> items = jedis.zrange("items", 0, -1);

			System.out.println(items);
		}

		/// ... when closing your application:
		pool.close();
	}
}
