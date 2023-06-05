package jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance(); //싱글톤만들어놓은것 가져옴.
		List<Emp> lst = ed.selectAll(0); //자료를 ArrayList에 담아서 가져옴
//		for (Emp emp: lst) {
//			System.out.println(emp);
//		}
		//정수범위로부터 스트림 얻기 p.792
		IntStream.rangeClosed(1 , 5).forEach(n-> {
			System.out.println("*****");
			System.out.println(n+"test");
		});
		//필터링 p.799
		lst.stream().filter(n->n.getEname().startsWith("K")).forEach(n->System.out.println(n));
		lst.stream().filter(n->n.getSal() >= 2000).forEach(n->System.out.println(n));
		
		//복수 개의 요소로 대체 p.801
		List<String> inList = Arrays.asList("10, 20, 30", "40, 50, 60");
								//자료를 고정해서 쓸때 씀. DB에선 쓰지 않음.
		
		inList.stream().flatMapToInt(a->{ //flatMapToInt: int형 배열 스트림 리턴.
			String[] strArr = a.split(","); //"" 안의 ,임 //쪼개서 String 배열에 넣음.
			for (String ss: strArr) {
				System.out.println(ss); //프린트해보면 앞에 공백 so 트림trim을 써줌.
			} //???출력결과: 왜 10부터 60까지 이어서 나오지 않지
			int[] intArr = new int[strArr.length]; //int배열에 넣음.
			for (int i=0; i<strArr.length; i++) {
				intArr[i] = Integer.parseInt(strArr[i].trim());
			}
			return Arrays.stream(intArr);
		}).forEach(n->System.out.println(n+1)); //n은 위에 intArr
		
		// 정렬 p.805
		System.out.println("---사번으로 정렬---");
		lst.stream().sorted().forEach(n->System.out.println(n)); //오류나니까 emp에가서 implements Comparable
		//Comparable을 구현한 요소에서만 sorted()메소드 호출.
		//Comparable 인터페이스는 기본적으로 오름차순
		
		System.out.println("---부서별 정렬---");
		lst.stream().sorted((n1, n2)->n1.getDeptno()-n2.getDeptno()).forEach(n->System.out.println(n));
		//음수,0리턴: 객체의 자리가 그대로 유지
		//양수: 두 객체 자리 바뀜
	}

}
