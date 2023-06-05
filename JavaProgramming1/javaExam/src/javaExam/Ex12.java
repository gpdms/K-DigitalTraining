package javaExam;

public class Ex12 {

	public static void main(String[] args) {
		//익명의 구현객체 p.354
		Aaa ss = new Aaa() { //모든 추상메소드의 실체메소드 구현해야.
			public void bbb() {
				System.out.println("bbb");
			}

			@Override
			public void kkk() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

}
