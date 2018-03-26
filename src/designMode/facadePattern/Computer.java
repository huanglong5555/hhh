package designMode.facadePattern;

public class Computer {
	private Cpu cpu;
	private ROM rom;
	private Ram ram;
	public Computer(){
		cpu=new Cpu();
		rom=new ROM();
		ram=new Ram();
	}
	public void start(){
		cpu.start();
		ram.start();
		rom.start();
	}
	public void shutdown(){
		cpu.shutdown();
		ram.shutdown();
		rom.shutdown();
	}
}
