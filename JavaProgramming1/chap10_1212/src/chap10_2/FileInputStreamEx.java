package chap10_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/file1.txt"); //자원에 접근
			int data;
			while( (data = fis.read()) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) { //exception 더큰거여서 뒤로.
			e.printStackTrace();
		}
	}

}
