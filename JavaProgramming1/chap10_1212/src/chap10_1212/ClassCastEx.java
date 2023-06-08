package chap10_1212;

class Animal{}
class Dog extends Animal {}
class Cat extends Animal {}

public class ClassCastEx {

	public static void main(String[] args) {
		//Animal ani = new Dog();
		//Dog dog = (Dog) ani;
		//Dog dog;
		//changeDog(ani);
		
		Animal ani = new Cat();
		changeDog(ani);

	}
	
	public static void changeDog (Animal animal) {
		if (animal instanceof Dog) {
			Dog dog = (Dog) animal;
			System.out.println("변환됩니다.");
		} else {
			System.out.println("변환 안됩니다.");
		}
	}
}
