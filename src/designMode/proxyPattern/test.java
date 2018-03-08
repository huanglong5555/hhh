package designMode.proxyPattern;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		testJdkProxy();
		testCglibProxy();

	}

	public static void testSimpleProxy() {
		SimpleProxy proxy = new SimpleProxy();

		SimpleInterface proxyObj = proxy.proxy(new SimpleInterface() {
			@Override
			public void doWork() {
				System.out.println("do something!");

			}
		});
		proxyObj.doWork();
	}
	
	public static void testJdkProxy(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		Map<String, String> jdkMap = (Map<String, String>) new JdkProxy().proxy(map);
		System.out.println(jdkMap.get("key1"));
	}
	public static void testCglibProxy(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		Map<String,String> cglibMap=(Map<String,String>)new CglibProxy().proxy(map);
		System.out.println(cglibMap.get("key1"));
	}

}
