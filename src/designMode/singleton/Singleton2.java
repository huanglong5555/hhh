package designMode.singleton;
/**
 * 线程安全
 * @author huanglong
 *
 */
public class Singleton2 {
	private static Singleton2 instanse = null;

	public static Singleton2 getInstanse() {
		if (instanse == null) {
			synchronized (Singleton2.class) {
				if (instanse == null)
					instanse = new Singleton2();
			}
		}
		return instanse;
	}
}
