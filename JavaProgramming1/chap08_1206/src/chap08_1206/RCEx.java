package chap08_1206;

public class RCEx {

	public static void main(String[] args) {
		RemoteControl rs;
//		rs = new RemoteControl(); //인터페이스는 생성자가 없어서 생성못함.
		rs = new Television(); //인터페이스 타입으로 변수를 선언하고 구현 객체 대입.
		rs = new Audio();

		
		
		//익명구현객체 : 한번하고 끝낼때. 재사용안할때.
												//인터페이스명임. 클래스명 아님. 사실상 클래스(객체)는 존재하지 않는 것. 익명의객체생성.
		RemoteControl rc2 = new RemoteControl() {
			private int volume;
			@Override
			public void turnOn() {
				System.out.println("turnOn");
				
			}

			@Override
			public void turnOff() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setVolume(int volume) {
				// TODO Auto-generated method stub
				
			}
			
		}; //세미콜론 꼭
		rc2.turnOn();
	}
	
	

}
