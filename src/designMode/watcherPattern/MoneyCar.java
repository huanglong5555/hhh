package designMode.watcherPattern;

import java.util.ArrayList;
import java.util.List;

public class MoneyCar implements Watched{

	List<Watcher> watcherList=new ArrayList<Watcher>();
	@Override
	public void addWatcher(Watcher watcher) {
		watcherList.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		watcherList.remove(watcher);
	}

	@Override
	public void niotifyWatchers() {
		for(Watcher w:watcherList)w.action();	
	}

}
