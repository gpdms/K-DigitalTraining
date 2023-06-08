
public class RcEx {

	public static void main(String[] args) {
		SmartTelevision st = new SmartTelevision();
		st.turnOn();
		st.search("https://www.naver.com");
		st.setVolume(8);
		st.turnOff();
	}

}
