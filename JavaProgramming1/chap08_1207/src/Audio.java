

public class Audio implements RemoteControl {
	//필드
		private int volume;
		private boolean mute;
		
		//turnOn() 추상 메소드의 실체 메소드
		public void turnOn() {
			System.out.println("Audio를 켭니다.");
		}
		
		//turnOff() 추상 메소드의 실체 메소드
		public void turnOff() {
			System.out.println("Audio를 끕니다.");
		}
		
		//setVolume()추상메소드의 실체메소드
		public void setVolume(int volume) {
			if(volume>RemoteControl.MAX_VOLUME) {
				this.volume = RemoteControl.MAX_VOLUME;
			} else if (volume<RemoteControl.MIN_VOLUME) {
				this.volume = RemoteControl.MIN_VOLUME;
			} else {
				this.volume = volume;
			}
			System.out.println("현재 Audio 볼륨 : " + this.volume);
		}
		
		//setMute(boolean mute) 디폴트메소드 오버라이딩
		@Override
		public void setMute(boolean mute) {
			this.mute = mute;
			if(mute) {
				System.out.println("Audio 무음처리합니다.");
			} else {
				System.out.println("Audio 무음해제합니다.");
			}
		}
		
		
}
