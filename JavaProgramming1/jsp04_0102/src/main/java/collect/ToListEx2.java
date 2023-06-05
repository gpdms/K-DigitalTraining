package collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ToListEx2 {

	public static void main(String[] args) {
		//asList는 아래를 합친 것.
		List<Student> tt2 = new ArrayList<>();
		tt2.add(new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul));
		//asList는 자료를 박아놓을때 씀. DB할땐 못씀. 자료가없으니까
		List<Student> totalList = Arrays.asList(
				new Student("홍", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student("김", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student("신", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student("박", 6, Student.Sex.FEMALE, Student.City.Seoul)
				);
		//Map은 <키(하나),값(여러개)>
		//groupingBy
		Map<Student.Sex, List<Student>> ms = totalList.stream()
				.collect(Collectors.groupingBy(Student::getSex));
												//Emp::getdeptno
		ms.get(Student.Sex.MALE).stream().forEach(s->System.out.println(s.getName()));
		//get(키)
		
		//mapping
		Map<Student.City, List<String>> ms2 = totalList.stream()
				.collect(Collectors.groupingBy(Student::getCity, 
						Collectors.mapping(Student::getName, Collectors.toList()))
						);
		ms2.get(Student.City.Seoul).stream().forEach(s->System.out.println(s));
		
		//평균구하기
		Map<Student.Sex, Double> ms3 = totalList.stream()
				.collect(Collectors.groupingBy(
							Student::getSex,
							Collectors.averagingDouble(Student::getScore)
							)
						);
		System.out.println(ms3.get(Student.Sex.MALE));
		
		//p.832
		//성별로 그룹핑 후 그룹에 속하는 학생 이름을 쉼표로 구분해서 문자열로 만듦
		//그룹에 속하는 학생 이름을 쉼표로 구분해서 문자열을 만들고, 성별을 키로 이름 문자열을 값으로 갖는 map생성.
		Map<Student.Sex, String> ms4 = totalList.stream()
				.collect(Collectors.groupingBy(
							Student::getSex, //성별로 그룹핑
							Collectors.mapping( 
									Student::getName,
									Collectors.joining(", ")
									)
							)
						);
		System.out.println(ms4.get(Student.Sex.MALE));
		
		Map<Student.City, String> ms5 = totalList.stream()
				.collect(Collectors.groupingBy(
							Student::getCity, 
							Collectors.mapping(
									Student::getName,
									Collectors.joining(", ")
									)
							)
						);
		System.out.println(ms5.get(Student.City.Seoul));
		
	}

}
