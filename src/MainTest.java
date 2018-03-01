import java.util.Hashtable;
import java.util.Vector;

public class MainTest {

	public static void main(String[] args) throws InterruptedException {
		// UUID.randomUUID();
		// System.out.println(Runtime.getRuntime().availableProcessors());
		Vector<String> vector = new Vector<String>();
		vector.add("dfd");
		String value=vector.get(0);
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("keyu", "value");
		hashTable.get("keyu");
		int i = 200000;
		while (i-- > 0) {
			hashTable.put("key" + i, "value" + i);
		}
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int i = 100000;
				while (i-- > 0) {
					hashTable.remove(hashTable.keys().nextElement());
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				int i = 100000;
				while (i-- > 0) {
					hashTable.remove(hashTable.keys().nextElement());
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(hashTable.size());
	}

}
