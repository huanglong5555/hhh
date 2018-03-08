package json;

import com.google.gson.Gson;
/**
 * google  goson  对于小的json处理十分的快
 * @author huanglong
 *
 */
public class GosonUtil {

	public static void main(String[] args) {
		gosonDemo();

	}

	public static String toJson(Object javaBean){
		Gson gson = new Gson();
		return gson.toJson(javaBean);
	}
	public static <T> T toBean(String json,Class<T> clas){
		Gson gson = new Gson();
		return gson.fromJson(json, clas);
	}
	private static void gosonDemo() {
		
		// Serialization
		JavaBean obj = new JavaBean();
		String json = toJson(obj);
		System.out.println(json);
		JavaBean obj2=toBean(json, JavaBean.class);
		System.out.println(obj2);
	}

}
