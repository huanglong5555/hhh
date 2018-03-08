package designMode.templateMethodPattern;

public class SubClass extends AbstractClass {

	@Override
	protected void doSomethingA() {
		System.out.println("implement dosomething a!");
	}

	@Override
	protected void doSomethingB() {
		System.out.println("implement dosomething B!");
	}

}
