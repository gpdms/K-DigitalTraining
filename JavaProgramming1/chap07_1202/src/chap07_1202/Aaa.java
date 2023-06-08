package chap07_1202;

import chap07_1.Ccc;

class Ddd extends Ccc{} //import하기. 패키지가 다르니까.
class Bbb extends Aaa {
	
}
public class Aaa {
	private int x = 10; //private붙이면 직접 접근 안됨. getter setter로 접근

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
}
