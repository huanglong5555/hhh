package designMode.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDK动态代理
 * 
 * 注意：代理的对象必须实现接口
 * 
 * 结果说明 JDK代理实现的委托（可以拿到代理对象的字段），推测：实现的是接口，然后用组合代理对象
 * @author huanglong
 *
 */
public class JdkProxy implements InvocationHandler{

	private Object target;
	public Object proxy(Object target){  //要代理特定类型 此处将Object替换特定类型
		this.target=target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)  
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//例子拦截某方法单独处理
//		if(method.getName()=="toString"){
//			return "Im proxy of tostring";
//		}
		return method.invoke(target, args);
	}

}
