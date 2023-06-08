

public interface RemoteControl {
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드 : 반드시 구현해야함. 구현 객체를 통해 호출 가능.
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드 : 중괄호 있는 메소드. 중괄호쓰고 default안쓰면 오류.
	//구현해도되고안해도되고. 재정의 됨. 구현 객체를 통해 호출 가능.
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//정적 메소드: 인터페이스로 바로 호출 가능. RemoteControl.changeBattery();
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
