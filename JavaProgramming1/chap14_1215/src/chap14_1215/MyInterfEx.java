package chap14_1215;

public class MyInterfEx {

	public static void main(String[] args) {
		MyInterf fi2 = new MyInterf() {

			@Override
			public void method(String str) {		
				System.out.println(str);
			}
		};
		fi2.method("test");
		
		//람다식
		MyInterf fi; 
		fi = (x) -> { //매개변수 하나이면 여기있는 ()괄호 생략 가능.
			System.out.println(x);
		};//실행문이 하나면 중괄호 생략 가능
		fi.method("test2");
	}

}
