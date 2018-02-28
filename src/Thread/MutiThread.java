package Thread;

public class MutiThread {
    
	public class InnorClass{
		
	}
	
	private static Object obj=new Object();
	public static void main(String[] args) {
		
		InnorClass c=new MutiThread().new InnorClass();
		
		MutiThread t=new MutiThread();
		
		
		new Thread() {
			@Override
			public void run() {
				t.sayTest("access ok");
			}
		}.start();
		
		try {
			synchronized (t) {
				t.wait();
			}
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static synchronized void say() {
		int i = 0;
		while (true) {
			System.out.println("hello " + i++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static synchronized void say(String msg) {
		System.out.println(msg);
	}
	public  synchronized void sayTest(String msg) {
		System.out.println(msg);
	}
}
