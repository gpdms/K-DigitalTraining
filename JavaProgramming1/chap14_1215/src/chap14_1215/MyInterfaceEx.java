package chap14_1215;

public class MyInterfaceEx {

	public static void main(String[] args) {
		MyInterface mi = s -> {
			return(s.equals("OK") ? 100 : 0);
		};
		
		System.out.println(mi.method("OK"));
	}

}
