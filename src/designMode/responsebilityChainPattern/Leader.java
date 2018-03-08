package designMode.responsebilityChainPattern;

public abstract class Leader {
	private Leader next;
	public void setNext(Leader leader){
		this.next=leader;
	}
	public Leader getNext(){
		return next;
	}
	public abstract void handle(ApplyFile applyFile);
}
