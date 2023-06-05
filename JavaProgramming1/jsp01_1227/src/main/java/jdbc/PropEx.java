package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		String path = PropEx.class.getResource("db.properties").getPath();
		//getResource(): 파일의 상대경로를 URL 객체로 리턴
		//getPath(): 파일의 절대 경로를 리턴
		path = URLDecoder.decode(path, "utf-8"); // 경로에 한글이 있을경우 한글을 복원
		prop.load(new FileReader(path)); //FileReader: 프로퍼티 파일로부터 데이터를 읽기 위해.
		String driver = prop.getProperty("driver"); //getProperty():"driver"라는 키의 값을 읽음.
		System.out.println(driver);

	}

}
