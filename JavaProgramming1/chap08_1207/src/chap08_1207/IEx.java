package chap08_1207;

public class IEx {

	public static void main(String[] args) {
//		I.d(); //인터페이스가 default 메소드이면 이렇게 못씀. 인터페이스가  static으로 되어있으면 쓸수있음.
				//default 는 재정의 해도되고 안해도되고. 
		I i = new I () {
			public void d() {
				System.out.println("dd");
			}
			
		}; //default는 재정의 안해도 오류 안뜸.세미콜론 반드시.
		i.d ();
		
	}

}
