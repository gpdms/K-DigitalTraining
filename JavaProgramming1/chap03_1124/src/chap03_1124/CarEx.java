package chap03_1124;

public class CarEx {

	public static void main(String[] args) {

//		Car car = new Car(); 매개변수 없는 것은 생성안되었기때문에 오류뜸.
//		Car car = new Car(30); 매개변수 있는것은 생성되었었기 때문에 때문에 됨. 
//		
//		car.num = 40;
//		car.str = "Test";
		// Car car; //int같이 데이터타입이라 생각하면됨. 뭐든 넣을 수 있음.
//		String str; 문자열만 저장. String 참조타입임. 방이무한하지만 문자열만.
//		int num; 4바이트 정수값만 저장. 방이 4개.

//생성자 선택1
		Car car1 = new Car();
		System.out.println("car1.company:" + car1.company);
		System.out.println();

//생성자 선택2
		Car car2 = new Car("자가용");
		System.out.println("car2.company:" + car2.company);
		System.out.println("car2.model:" + car2.model);
		System.out.println();

//생성자 선택3
		Car car3 = new Car("자가용", "빨강");
		System.out.println("car3.company:" + car3.company);
		System.out.println("car3.model:" + car3.model);
		System.out.println("car3.color:" + car3.color);
		System.out.println();

// 생성자 선택4
		Car car4 = new Car("택시", "검정", 200);
		System.out.println("car4.company:" + car4.company);
		System.out.println("car4.model:" + car4.model);
		System.out.println("car4.color:" + car4.color);
		System.out.println("car4.maxSpeed:" + car4.maxSpeed);

	}
}
