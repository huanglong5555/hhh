package designMode.visitorPattern;

import java.util.ArrayList;
import java.util.List;

public class Family {
	private List<Animal> animals = new ArrayList<Animal>();
	public void addAnimal(Animal animal){
		animals.add(animal);
	}
	public void action(Person p){
		for(Animal a:animals){
			a.Accept(p);
		}
	}
}
