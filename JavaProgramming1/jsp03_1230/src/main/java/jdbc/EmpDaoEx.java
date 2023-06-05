package jdbc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpDaoEx {

	public static void main(String[] args) {
		EmpDao ed = EmpDao.getInstance();
		ed.realSelectAll();
		List<Emp> lst = ed.selectAll(0);
		//lst.stream().forEach(n->System.out.println(n));
		
		//collect
		    //키(부서번호), 값(리스트:직원들정보)
		Map<Integer, List<Emp>> md1 = lst.stream().collect(
					Collectors.groupingBy(Emp::getDeptno)
		);
		
		md1.get(10).stream().forEach(n->System.out.println(n));
		//10번부서
		
		//평균구하기
		Map<Integer, Double> md2 = lst.stream().collect(
				Collectors.groupingBy(Emp::getDeptno,
						Collectors.averagingDouble(Emp::getSal)
						)
		);
	
		System.out.println(md2.get(20));
		
		//mapping
		Map<Integer, String> md3 = lst.stream().collect(
				Collectors.groupingBy(Emp::getDeptno,
						Collectors.mapping(Emp::getEname, //ename을 가져와서
								Collectors.joining(", ")) //콤마로 구분
						)
		);
	
		System.out.println(md3.get(30));
		
	}

}
