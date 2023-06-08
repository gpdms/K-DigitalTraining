package chap09_3;

public class Anonymous {
	//필드 초기값으로 대입
	Person field = new Person() { //생성자나오고 중괄호세미콜론 이면 자식.
		void work() {
			System.out.println("출근합니다.");
		}

		@Override
		void wake() {
			System.out.println("6시에 일어납니다.");
		}
	};
	
	
	
	void method1() {
		//로컬 변수값으로 대입
		Person localVar = new Person() {
			void walk() {
				System.out.println("산책합니다.");
			}

			@Override
			void wake() {
				System.out.println("7시에 일어납니다.");
				walk();
			}
		};
		//로컬 변수 사용
		localVar.wake();
	}
	
	void method2(Person person) {
		person.wake();
	}
	
	
}
