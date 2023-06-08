package chap10_1212;

public class NullPointerExceptionEx {

	public static void main(String[] args) {
		String data = null;
		
		try {
			System.out.println(data.toString());
		} catch(NullPointerException e) {
			//e.printStackTrace(); //예외 메시지 뜨게.
			System.out.println(e.getMessage()); //메시지 출력
			data = "test";
			System.out.println(data.toString()); //업무로 활용
		}
		
	}
	
}
