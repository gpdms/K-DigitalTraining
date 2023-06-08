package chap12_1;

public class ThreadEx {

	public static void main(String[] args) {
//		for(;;) {
//			
//		} 무한루프 돌면 아래 코드가 실행되지 못한다고 컴파일러가 오류메시지.

		Thread th = new WorkThread();
		th.start();

		Thread th2 = new Thread(new WorkThread2());
		th2.start();

		Thread th3 = new Thread() {
			@Override
			public void run() {
				for (;;) {
					System.out.println("Thread3");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}; // 익명의자식객체라서 세미콜론
		th3.start();

		Thread th4 = new Thread(() -> {
			for (;;) {
				System.out.println("Thread4");
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		th4.start();
	}

}
