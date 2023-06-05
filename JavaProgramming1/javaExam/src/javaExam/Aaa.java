package javaExam;

public interface Aaa {
	void kkk();
	void bbb();
	default void sss() { //default안붙이면 객체 생성시 실체메소드 작성해야함. default붙여서 상속하는ㅁㅁ뭐
		System.out.println("sss");
	}
	
}
