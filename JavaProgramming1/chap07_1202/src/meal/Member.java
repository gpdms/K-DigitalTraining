package meal;

public class Member {
	Meal HE = new Meal ("점심식사", 3);
	Meal JK = new Meal("점심식사", 4);
	Meal MJ = new Meal("점심식사", 5);
	
	int run() {
		System.out.println("식사시간을 기다리는 중입니다.");
		if(HE.roll() == false) {stop(); return 1;}
		if(JK.roll() == false){stop(); return 2;}
		if(MJ.roll() == false){stop(); return 3;}
		return 0;
	}
	
	void stop() {
		System.out.println("책상을 뒤엎습니다.");
	}
}
