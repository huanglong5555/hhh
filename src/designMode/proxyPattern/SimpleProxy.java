package designMode.proxyPattern;

public class SimpleProxy implements SimpleInterface{

	private SimpleInterface target;
	
	public SimpleInterface proxy(SimpleInterface target){
		this.target=target;
		return this;
	}
	@Override
	public void doWork() {
		// TODO Auto-generated method stub
		target.doWork();
	}

}
