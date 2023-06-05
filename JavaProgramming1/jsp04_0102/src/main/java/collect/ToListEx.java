package collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ToListEx {

	public static void main(String[] args) {
		List<Student> totalList = Arrays.asList(
				new Student("홍", 10, Student.Sex.MALE),
				new Student("김", 6, Student.Sex.FEMALE),
				new Student("신", 10, Student.Sex.MALE),
				new Student("박", 6, Student.Sex.FEMALE)
				);
		
		//남자만 collect
		List<Student> maleList = totalList.stream()
				.filter(s->s.getSex()==Student.Sex.MALE)
				.collect(Collectors.toList());
		maleList.stream().forEach(s->System.out.println(s.getName()));
	}

}
