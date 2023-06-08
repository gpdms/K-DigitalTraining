package chap13_1;

public class Box<TT> { //T가 타입. 타입을 바꿀 수 있는 변수같은.
	private TT t;

	public TT getObject() {
		return t;
	}

	public void setObject(TT t) {
		this.t = t;
	}
	
}
