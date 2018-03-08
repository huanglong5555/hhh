package designMode.responsebilityChainPattern;

public class ApplyFile {
	public ApplyFile(String filename,int level){
		this.filename=filename;
		this.level=level;
	}
	private String filename;
	private int level;
	public String getFilename() {
		return filename;
	}
	public int getLevel() {
		return level;
	}
}
