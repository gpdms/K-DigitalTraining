package test;

class Aaa {
	void prn() {
		System.out.println("Aaa");
	}
}

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class<?> hc = Class.forName("test.Aaa"); //클래스가 있느냐
		Aaa hi = (Aaa) hc.newInstance(); //있으면 객체생성
		hi.prn();
	}

}
