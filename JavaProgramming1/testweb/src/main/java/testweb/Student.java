package testweb;

public class Student {

	int id;
	String name;
	String hakbun;
	String addr;
	
	public Student(int id, String name, String hakbun, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.hakbun = hakbun;
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", hakbun=" + hakbun + ", addr=" + addr + "]";
	}
	
}
