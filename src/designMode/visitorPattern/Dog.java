package designMode.visitorPattern;

public class Dog extends Animal{

	@Override
	public void Accept(Person person) {
		person.feed(this);
		wagTail();
		eat();
	}
    public void wagTail(){
    	System.out.println("wag tail!");
    }
    public void eat(){
    	System.out.println("eat food!");
    }
}
