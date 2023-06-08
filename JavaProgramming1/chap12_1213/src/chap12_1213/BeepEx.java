package chap12_1213;

import java.awt.Toolkit;

public class BeepEx {
	

	public static void main(String[] args) { //메인스레드
		Thread mt = Thread.currentThread();
		System.out.println("이름"+mt.getName());
		
		//람다식: new이름을 없어도됨. run메소드를 안써도됨. 메소드 하나여야 가능.
	Thread th6 = new Thread(() -> {
		for (int i=0; i<5; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("이름"+Thread.currentThread().getName());
	}
	});
	th6.start();
		
		//BeepTask2 
		Runnable th3 = new BeepTask2();
		Thread th4 = new Thread(th3);
		th4.start();
		
		Thread th5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i=0; i<5; i++) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Beep Run5!");
			}
			}
		});
		th5.start();
		
		
		Thread th = new BeepTask();
		th.start(); //스레드
		
		
		Thread th2 = new Thread() {
			public void run() {
				for (int i=0; i<5; i++) {
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Beep2!");
				}
			}
		};
		th2.start(); //스레드
		
		
		
		
		
	} //스레드 총 3개	

}
