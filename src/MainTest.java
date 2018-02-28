import redis.JRedisSubdcribeListener;
import redis.RedisPool;
import redis.clients.jedis.Jedis;

public class MainTest {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		new Thread() {
			@Override
			public void run() {
				testSubscribe();
			}
		}.start();
		try {
			testPushMess();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 测试订阅发布
	 */
	public static void testSubscribe() {
		Jedis jedis = RedisPool.getJedis();
		JRedisSubdcribeListener listener = new JRedisSubdcribeListener();
		jedis.subscribe(listener, "redisChatTest");
	}

	public static void testPushMess() throws InterruptedException {
		Jedis jedis = RedisPool.getJedis();
		jedis.publish("redisChatTest", "我是天才");
		Thread.sleep(5000);
		jedis.publish("redisChatTest", "我牛逼");
		Thread.sleep(5000);
		jedis.publish("redisChatTest", "哈哈");
	}

}
