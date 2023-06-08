package chap10_3;

public class FileInputStream implements AutoCloseable {

	private String file;

	public FileInputStream(String file) {
		super();
		this.file = file;
	}
	
	public void read() {
		System.out.println(file + "읽기");
	}

	@Override
	public void close() throws Exception { //close()를 만들어줌. finallly 안써도됨
		System.out.println(file + "닫기");
		
	}
	
}
