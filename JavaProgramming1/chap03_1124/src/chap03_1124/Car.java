package chap03_1124;

public class Car {
//	int num;
//	String str;
//	
//	Car(int number) {
//		
//	}
//	Car() {
//		
//	}
	//매개변수있는 것과 없는 것은 다름. 위 두 Car은 다른 Car임.
	
	
//필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
//생성자1
	Car() {
		
	}
	
//생성자2
	Car(String model) {
		this.model = model;
	}
	
//생성자3
	Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
//생성자4
	Car(String model, String color, int maxSpeed) {
	this.model = model;
	this.color = color;
	this.maxSpeed = maxSpeed;
}

	
	
	
	
	
	
}

