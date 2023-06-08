package chap07_1202;

class Com extends Cal {
	
	int x = 20;
	@Override
	public String toString() {
		return "Com [x=" + x + "]";
	}
	
	@Override //생략해도 되지만 붙여주면 실수를줄일수있음
	void size() {
			System.out.println("Com"); //같은메소드명씀. 오바리이딩함. 출력하면 얘가나옴.
			super.size(); //부모꺼 출력하게 하고 싶으면 super
	}
}

public class Cal {
	void size() {
		System.out.println("Cal");
	}
}
