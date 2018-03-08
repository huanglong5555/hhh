package designMode.commandPattern;

public class Command1 extends Command {

	private Receiver receiver;
	public Command1(Receiver receiver) {
		this.receiver=receiver;
	}

	@Override
	public void excute() {
		receiver.dosomething();
	}

}
