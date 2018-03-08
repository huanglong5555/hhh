package designMode.builderPattern;

public abstract class Builder {

	public abstract void createCpu(String cpu);
	public abstract void createMainBoard(String mainBoard);
	public abstract void createRom(String rom);
	public abstract void createRam(String ram);
	public abstract Computer GetbuildComputer();
}
