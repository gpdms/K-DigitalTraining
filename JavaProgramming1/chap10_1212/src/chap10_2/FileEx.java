package chap10_2;

import java.io.File;
import java.io.IOException;

public class FileEx {
	//자바책2 p.1020
	public static void main(String[] args) {

		File dir = new File("c:/Temp/Dir");
		File file1 = new File("c:/Temp/file1.txt");
		
		if(dir.exists() == false) {
			dir.mkdirs(); //Dir폴더 생김
		}
		try {
			file1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
