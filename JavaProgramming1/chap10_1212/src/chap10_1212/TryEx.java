package chap10_1212;

public class TryEx {

	public static void main(String[] args) {

		try {
			Class.forName("java.lang.String");
			System.out.println("있습니다"); 
		} catch (ClassNotFoundException e) {
			System.out.println("없습니다");
		} finally {
			System.out.println("항상 실행");
		}
	}

}
