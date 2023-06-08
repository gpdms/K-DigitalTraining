package chap06_1130;
class _6_Ddd{
}

public class _6_Ccc {
	_6_Ddd a; //클래스 만든 것을 필드로 하나 만듦.
	int x;
	String s;
	
	_6_Ccc (int x, String s) {
		this.x = x;
		this.s = s;
	}
	
	//생성자로 만든 기능
	_6_Ccc(_6_Ddd d){
		a = d;
	}
	//메소드로 만든기능. 기능은 동일하지만, 메소드는 실행용이기때문에 이경우는 생성자가 더 적합하겠음
	void mmm (_6_Ddd d) {
		a = d;
	}
	
	
	public static void main (String[] args) {
//		c.a = d;
//		c.mmm(d);  둘이 같은것.
		
		_6_Ddd d = new _6_Ddd();
//		_6_Ccc c = new _6_Ccc(d);
		_6_Ccc c = new _6_Ccc(new _6_Ddd());
		_6_Ccc c1 = new _6_Ccc(10, "가나다");
//		_6_Ccc c1 = new _6_Ccc(10, new String("가나다"));
		

	}
}
//매개변수 가려면 값이 가던가 힙영역의 공간이 ???