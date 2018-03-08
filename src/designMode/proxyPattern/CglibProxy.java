package designMode.proxyPattern;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 与jdk代理相反 cglib是利用实现父类进行代理，所以相对于jdk代理 代理对象不需要实现接口    但需要可以继承  不能为final
 * 需要导入cglib包（spring-core中包含了，此处导入spring-core）
 * 
 * @author huanglong
 *
 */
public class CglibProxy implements MethodInterceptor {

	private Object target;

	public Object proxy(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		return arg1.invoke(target, arg2);
	}

}
