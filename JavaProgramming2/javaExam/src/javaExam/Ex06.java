package javaExam;

public class Ex06 {
	public static void main (String[] args) {
		int i = 0;
		int ret = 100 + i++;
		System.out.println(ret);
		System.out.println(i);
		
		int j = 0;
		int res = 100 + ++j;
		System.out.println(res);
		System.out.println(j);
	}
}
