package designMode.statusPattern;

public class Lift {


	private ILiftStatus liftStatus;

	public ILiftStatus getLiftStatus() {
		return liftStatus;
	}

	public void setLiftStatus(ILiftStatus liftStatus) {
		this.liftStatus = liftStatus;
	}

	public void openDoor() {
		liftStatus.openDoor();
	}

	public void closeDoor() {
		liftStatus.closeDoor();
	}

	public void up() {
		liftStatus.up();
	}

	public void down() {
		liftStatus.down();
	}

	public void stop() {
		liftStatus.stop();
	}
}
