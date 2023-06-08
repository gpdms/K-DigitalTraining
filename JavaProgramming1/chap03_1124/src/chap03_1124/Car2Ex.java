package chap03_1124;

public class Car2Ex {

	public static void main(String[] args) {
		Car2 myCar = new Car2();
		
		myCar.setGas(5);		//Car의 setGas() 메소드 호출
		
		boolean gasState = myCar.isLeftGas();	//Car의 isLeftGas() 메소드 호출
		if(gasState) {
			System.out.println("출발합니다.");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}

	}

}
