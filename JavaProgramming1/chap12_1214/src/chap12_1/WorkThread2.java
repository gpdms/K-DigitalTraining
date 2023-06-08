package chap12_1;

public class WorkThread2 implements Runnable{

	@Override
	public void run() {
		for (;;) {
			System.out.println("WorkThread2");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
