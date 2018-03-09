package designMode.strategePattern.simpleDemo;

public class How2Company {
	private ToCompany way = null;
	public How2Company(ToCompany way){
		this.way=way;
	}
	public void go(){
		if(way!=null)way.toCompany();
	} 
}
