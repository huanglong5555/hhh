package designMode.watcherPattern;

public class Thief implements Watcher{

	@Override
	public void action() {
		System.out.println("发现车，准备开抢!");
	}

}
