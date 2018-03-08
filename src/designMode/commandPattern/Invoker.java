package designMode.commandPattern;

public class Invoker {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void action() {
		command.excute();
	}
}
