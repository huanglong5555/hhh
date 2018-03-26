package designMode.statusPattern;

public abstract class ILiftStatus {

	protected Lift lift;
	public ILiftStatus(Lift lift){
		this.lift=lift;
	}

	public abstract void openDoor();

	public abstract void closeDoor();

	public abstract void up();

	public abstract void down();

	public abstract void stop();

}
