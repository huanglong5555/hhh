package designMode.commandPattern;

public class test {

	public static void main(String[] args) {
		//receiver 和 command 可以有多个实现
		Receiver receiver=new Receiver1();
		Command command=new Command1(receiver);
		Invoker invoker=new Invoker();
		invoker.setCommand(command);
		invoker.action();
	}

}
