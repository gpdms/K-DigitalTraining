package chap13_1;

public class ProductEx {

	public static void main(String[] args) {
		Product<Tv, String> pro1 = new Product<>();
		pro1.setKind(new Tv());
		pro1.setModel("스마트Tv");
		Tv tv = pro1.getKind();
		String tvModel = pro1.getModel();
	}

}
