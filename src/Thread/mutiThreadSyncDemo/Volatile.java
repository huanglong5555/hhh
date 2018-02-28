package Thread.mutiThreadSyncDemo;

/**
 * volatile 的修改并不会自动加锁，所以在多线程中同事修改时依然会出问题
 * @author huanglong
 *
 */
public class Volatile implements Runnable {

	volatile int num = 0;

	public static void main(String[] args) throws InterruptedException {
		Volatile task = new Volatile();
		Thread thread1= new Thread(task);
		Thread thread2=new Thread(task);
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(task.num);
	}

	@Override
	public void run() {
		int i = 0;
		while (i++ < 10000) {
			num++;
			//System.out.println(num++);
		}
	}

}
