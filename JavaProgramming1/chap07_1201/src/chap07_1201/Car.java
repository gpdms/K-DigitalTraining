package chap07_1201;

public class Car {
	String model;
	int speed;
	
	Car(String model){
		this.model = model;
	}
	
	Car(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for (int i=10; i<=50; i+=10) {
			this.speed = i;
			System.out.println(this.model +"가 달립니다.(시속:"+this.speed + "km/h)");
		}
	}
	
}
