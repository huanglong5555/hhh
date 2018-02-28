package Thread.mutiThreadSyncDemo;

public class Printer implements Runnable {
     
	public static void main(String[] args) {
		// 三个对象刚好形成环型锁
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();

		new Thread(new Printer(c, a, "A")).start();
		new Thread(new Printer(a, b, "B")).start();
		new Thread(new Printer(b, c, "C")).start();

	}

	Object pre = null;
	Object self = null;

	String name;

	public Printer(Object pre, Object self, String name) {
		this.pre = pre;
		this.self = self;
		this.name = name;
	}

	@Override
	public void run() {
		int i = 0;
		while (i++ < 10) {
			synchronized (pre) {
				synchronized (self) {
					System.out.println(name + "  print " + i);
					self.notify();
				}
				try {
					pre.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
