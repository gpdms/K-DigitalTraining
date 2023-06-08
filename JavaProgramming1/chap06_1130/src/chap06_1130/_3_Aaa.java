package chap06_1130;

public class _3_Aaa {
	int a;
	int b;
	int c;
	
//생성자
	_3_Aaa(){
		
	}
	
	_3_Aaa(int a) {
//		this.a = a;
		this(a, 0, 0); //맨아래 생성자를 호출함. 어차피 초기값0이니까 0줌. 고칠일 있으면 맨아래 생성자만 고치면 됨.
	}
//	Aaa(int b) {}
		//위랑 같음. 클래스 이름 같고, 개수같고, 타입같아서.
		//시그니처가 같음.
	
	
	_3_Aaa(int a, int b){
//		this.a = a;
//		this.b = b;
		this(a,b,0);
	}
	
	_3_Aaa(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
