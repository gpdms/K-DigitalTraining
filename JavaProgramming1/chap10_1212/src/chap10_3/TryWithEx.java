package chap10_3;

public class TryWithEx {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("file.txt"); ) {
			fis.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}

}
