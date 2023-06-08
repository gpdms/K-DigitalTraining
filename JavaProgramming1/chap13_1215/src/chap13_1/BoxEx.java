package chap13_1;

public class BoxEx {

	public static void main(String[] args) {
		Box<String> box = new Box<String>(); //<>목적:타입을 분명하게 정하고 싶어서. 
		//쓰는순간 클래스(Box)가 가지고 있는 필드(TT)의 타입(String)을 정하는게 제네릭.
		box.setObject("홍길동");
		String name = /*(String)*/ box.getObject(); //String으로 강제 형변환. 안해도됨.
		
		Box<Apple> box1 = new Box<Apple>();
		box1.setObject(new Apple()); //홍길동 있던 자리 Apple()로 바꿈.
		Apple apple = (Apple) box1.getObject(); //Apple로 강제 형변환
	}

}
