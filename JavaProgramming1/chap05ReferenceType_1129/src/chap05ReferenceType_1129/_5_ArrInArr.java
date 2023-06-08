package chap05ReferenceType_1129;

public class _5_ArrInArr {

	public static void main(String[] args) {
		//이차원배열로 구구단
			
//			for(int i=2; i<=9; i++) {
//				for(int j=1; j<=9;j++) {
//					System.out.println(i+" "+j+" "+i*j);
//				}
//			}
			
		int[][] gugu = new int[10][10]; //배열길이 8 9는 안됨????
		
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				gugu[i][j]=i*j;
				System.out.println(i+"X"+j+"="+gugu[i][j]);
			}
		}
		
		//출력
//		for(int i=2; i<=9; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.println(i+"X"+j+"="+gugu[i][j]);
//			}
//		}
				
	}

}
