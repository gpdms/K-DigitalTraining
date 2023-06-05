package javaExam;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bbb bus = new Bbb();
		Ccc taxi = new Ccc();
		
		driver.drive(bus);
		driver.drive(taxi);
	}

}
