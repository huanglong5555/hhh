package designMode.singleton;
/**
 * 线程安全 但即使生命周期中对象未使用也会创建
 * @author huanglong
 *
 */
public class Singleton {
private static final Singleton singleton = new Singleton();
	
	public static Singleton getInstanse(){
		return singleton;
	} 
}
