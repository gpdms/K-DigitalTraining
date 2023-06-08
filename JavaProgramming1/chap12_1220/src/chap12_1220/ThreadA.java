package chap12_1220;

public class ThreadA extends Thread {
	public ThreadA() {
		this.setName("A스레드");
	}

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			System.out.println(this.getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
