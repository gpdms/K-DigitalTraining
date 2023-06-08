package chap02;

public class ArrayEx2 {
//								  ( 파라미터 )	
	public static int add(int[] scores) {
		int sum = 0;
		for(int i=0; i<3; i++) {
			sum+= scores[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		// 값의 리스트로 배열 생성
		int[] scores;
//		scores = {83, 90, 87}; 이렇게 쓰면 안됨
		scores = new int[] {83, 90, 87}; //new 객체 생성. 참조형데이터타입의 값을 넣을 때 필요.
		int sum1 = 0;
		for(int i=0; i<scores.length; i++) {
			sum1 += scores[i];
		}
		System.out.println("총합 : " + sum1);
		
		
		int sum2 = add( new int[] {83, 90, 87});
		System.out.println("총합 : " + sum2);
		System.out.println();
		
		
	}

}
