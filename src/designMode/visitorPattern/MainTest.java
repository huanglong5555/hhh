package designMode.visitorPattern;

public class MainTest {

	public static void main(String[] args) {
		Animal dog=new Dog();
		Animal cat=new Cat();
		
		Family family=new Family();
		family.addAnimal(dog);
		family.addAnimal(cat);
		
		Person owner=new Onwer();
		family.action(owner);
		Person stranger=new Stanger();
		family.action(stranger);

	}

}
