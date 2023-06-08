package chap09_4;

public class OutterEx {
	public static void main (String[] args) {
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested();
	
		nested.print();
		
	}
}
