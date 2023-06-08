package chap07_1205;

import java.util.Scanner;

public class DriverEx {

	public static void main(String[] args) {
		
		Driver driver = new Driver();
//		Bus bus = new Bus();
//		Taxi taxi = new Taxi();
		Vehicle vehicle;
		
//		driver.drive(bus);
//		driver.drive(taxi);
		
		Scanner scan = new Scanner(System.in);
		System.out.print("택시와 버스 중 하나를 선택>");
		String inS = scan.nextLine();
		if(inS.equals("택시")) {
			vehicle = new Taxi();
			driver.drive(vehicle);
		}else if (inS.equals("버스")) {
			vehicle = new Bus();
			driver.drive(vehicle);
		}
	}

}
