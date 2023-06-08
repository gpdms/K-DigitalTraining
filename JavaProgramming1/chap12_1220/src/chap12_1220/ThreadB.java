package chap12_1220;

public class ThreadB extends Thread {
	public ThreadB() {
		this.setName("B스레드");
	}

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(this.getName());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
