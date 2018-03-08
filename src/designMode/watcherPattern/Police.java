package designMode.watcherPattern;

public class Police implements  Watcher {

	@Override
	public void action() {
		System.out.println("车来了准备保护！");	
	}

}
