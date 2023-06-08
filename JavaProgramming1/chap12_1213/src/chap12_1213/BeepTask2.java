package chap12_1213;

public class BeepTask2 implements Runnable{

	@Override
	public void run() {
		for (int i=0; i<5; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("BeepRun!");
		}
	}

}
