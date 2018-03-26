package designMode.visitorPattern;

public class Onwer extends Person{

	@Override
	public void feed(Animal animal) {
		
		oilFood();
		System.out.println("喂食物给："+animal.getName());
	}

	private void oilFood(){
		System.out.println("煮食物！");
	}
}
