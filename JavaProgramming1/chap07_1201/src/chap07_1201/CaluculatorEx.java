package chap07_1201;

public class CaluculatorEx {

	public static void main(String[] args) {
		Calculator myCal = new Calculator();
		
		//정사각형의 넓이 구하기
		double result1 = myCal.areaRectangle(10);
		System.out.println(result1);
		
		//직사각형의 넓이 구하기
		double result2 = myCal.areaRectangle(10, 20);
		System.out.println(result2);
	}

}
