
public class Child extends Parent {
	public int studentNo;
	
	public Child (String name, int studentNo) {
		super(name);
		this.name = name;
		this.studentNo = studentNo;
	}


public static void main (String [] arg) {
	Parent parent = new Child("김", 2022);
	System.out.println(parent);
	
}


@Override
public String toString() {
	return  studentNo +","+ name ;
}
}