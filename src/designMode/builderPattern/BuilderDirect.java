package designMode.builderPattern;

public class BuilderDirect {
	Builder builder;
	public BuilderDirect(Builder builder) {
		this.builder=builder;
	}
	//按照一定的顺序对复杂对象进行建造（控制建造对象的流程顺序）
	public Computer createComputer(String cpu,String mainBoard,String rom,String ram){
		builder.createCpu(cpu);
		builder.createMainBoard(mainBoard);
		builder.createRam(ram);
		builder.createRom(rom);
		return builder.GetbuildComputer();
	}
}
