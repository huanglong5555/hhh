package designMode.visitorPattern;

public class Stanger extends Person{

	@Override
	public void feed(Animal animal) {
		picFood();
		
	}
	private void picFood(){
		System.out.println("拿袋装食物！");
	}

}
