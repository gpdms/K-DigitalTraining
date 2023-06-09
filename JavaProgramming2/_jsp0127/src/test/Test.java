package test;

public class Test {
	private static String aaa;
	public static void setAaa(String aaa) {
		//this.aaa = aaa; this못씀.static때문에.
		Test.aaa = aaa; //이건 가능
	}
	
	
	public static String getAaa() { //static해서 객체생성없이 사용가능
		return aaa;
	}
}
