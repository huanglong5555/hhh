package designMode.responsebilityChainPattern;

public class Ceo extends Leader {

	private String name = "ceo";
	private final int level = 99;

	@Override
	public void handle(ApplyFile applyFile) {
		if (level > applyFile.getLevel()) {
			System.out.println(name + "处理了" + applyFile.getFilename());
		} else if (getNext() != null) {

			System.out.println(name + "交给"+getNext().getClass() + applyFile.getFilename());
			getNext().handle(applyFile);
		}else{
			System.out.println("流程出错，无法处理"+applyFile.getFilename());
		}

	}

}
