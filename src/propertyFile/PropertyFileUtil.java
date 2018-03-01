package propertyFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertyFileUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		InputStream input = PropertyFileUtil.class.getClassLoader().getResourceAsStream("propertyFile/common.properties");
		//File file=new File("classpath:propertyFile/common.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=prop.getProperty("IP_REDIS_SERVER");
		System.out.println(value);
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
