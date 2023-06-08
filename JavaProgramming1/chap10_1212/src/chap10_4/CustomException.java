package chap10_4;

public class CustomException extends RuntimeException {
	//1. 매개변수가 없는 기본 생성자
	CustomException() {
		
	}
	
	//2. 예외 발생 원인(예외메시지)을 전달하기 위해  String타입의 매개변수를 갖는 생성자
	CustomException(String message) {
		super(message); //RuntimeException 클래스의 생성자를 호출
	}
}
