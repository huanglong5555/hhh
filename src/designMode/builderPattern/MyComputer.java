package designMode.builderPattern;

public class MyComputer extends Builder {

	private Computer computer;
	public MyComputer(){
		computer=new Computer();
	}
	@Override
	public void createCpu(String cpu) {
		computer.setCpu(cpu);
		
	}
	@Override
	public void createMainBoard(String mainBoard) {
		computer.setMainBoard(mainBoard);
		
	}
	@Override
	public void createRom(String rom) {
		computer.setRom(rom);
		
	}
	@Override
	public void createRam(String ram) {
		computer.setRam(ram);
		
	}
	@Override
	public Computer GetbuildComputer() {
		return computer;
	}
	
	

}
