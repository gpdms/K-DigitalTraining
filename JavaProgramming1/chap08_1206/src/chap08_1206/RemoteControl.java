package chap08_1206;

public interface RemoteControl {
	//상수
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드 : 반드시 구현해야함
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	//디폴트 메소드 : 구현해도되고안해도되고. 사실은 구현객체가 가지고 있는 인스턴스 메소드라고 생각해야.
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		} else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//정적 메소드: 객체가 없어도 인터페이스만으로 호출 가능.
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
}
