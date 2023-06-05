package javaExam;

public class Ex11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]sc = {95, 71, 84};
		int sum = 0;
		for ( int nn : sc) {
			sum = sum + nn;
		}
		
		System.out.println(sum);
		double avg = (double) sum/3; //또는 sum/3.0
		System.out.println(avg);
	}

}
