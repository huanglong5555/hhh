package designMode.responsebilityChainPattern;

public class test {

	public static void main(String[] args) {
		

		Manageer manager=new Manageer();
		CTO cto=new CTO();
		Ceo ceo=new Ceo();
		manager.setNext(cto);
		cto.setNext(ceo);
		
		ApplyFile file=new ApplyFile("审核文件等级1", 1);
		manager.handle(file);
		
		file=new ApplyFile("审核文件等级4", 4);
		manager.handle(file);
		
		file=new ApplyFile("审核文件等级6", 6);
		manager.handle(file);
		
	}

}
