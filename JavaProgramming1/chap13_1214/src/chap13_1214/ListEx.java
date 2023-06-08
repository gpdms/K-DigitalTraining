package chap13_1214;

import java.util.List;
import java.util.ArrayList;

public class ListEx{

	public static void main(String[] args) {
		List list = new ArrayList(); //자식객체
		list.add("hello");
		list.add(3.14);
		list.add(23); //타입달라도 다 넣을 수 있음. but 타입정해서하는게 좋음.
		String str = (String) list.get(0); //(String)강제 형변환
		Object obj = list.get(0);
		System.out.println(str);
		
		//제네릭
		List<String> list2 = new ArrayList<String>(); //<>안에는 클래스타입만. String, Integer
		//인덱스에 객체(String) 주솟값이 들어감. null일경우 nullpointer오류뜰 가능성. 
		list2.add("dffasdf234"); //정수 쓸 경우 오류뜸
		System.out.println(list2.get(0));
		
	}

}
