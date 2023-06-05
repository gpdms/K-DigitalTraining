package _jsp0126;

import java.util.HashMap;
import java.util.Map;

public class Ther {
	private Map<String, Double> cm = new HashMap<>();
				//위치, 온도 정보저장할거임
	

	
	//메소드
	public void setCel(String loc, Double val) {
		cm.put(loc, val); //해시맵에 키,값을 집어넣는 과정.
	}
	
	public Double getCel(String loc) {
		return cm.get(loc); //키로 값을 불러옴.
	}
	
	public Double getFah(String loc) {
		Double cel = cm.get(loc);
		return cel.doubleValue()*1.8+32.0;
	}
	
	public String getInfo() {
		return "온도변환기";
	}
}
