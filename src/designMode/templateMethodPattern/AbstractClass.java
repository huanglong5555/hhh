package designMode.templateMethodPattern;

/**
 * 模版方法模式
 * 
 * 使用场景：多个子类有相同方法但内部具体实现不一样时（如通卡充值）
 * 
 * @author huanglong
 *
 */
public abstract class AbstractClass {
	public void templateMethod() {
		doSomethingA();
		doSomethingB();
	}

	protected abstract void doSomethingA();

	protected abstract void doSomethingB();
}
