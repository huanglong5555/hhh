package designMode.visitorPattern;

public class Cat extends Animal{

	@Override
	public void Accept(Person person) {
		person.feed(this);
		
		MiaoMiao();
		sleep();
	}
	
	public void MiaoMiao(){
		System.out.println("maio miao!");
	}
	public void sleep(){
		System.out.println("sleep with not eat!");
	}

}
