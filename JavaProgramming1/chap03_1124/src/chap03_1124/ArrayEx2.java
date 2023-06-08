package chap03_1124;

import java.util.Scanner;

public class ArrayEx2 {

	public static void main(String[] args) {
//		int[][] scores = {{90, 95, 80}, 
//								{92, 96, 85}, 
//								{70, 75, 80}};
//		
//		for (int i=0; i<scores.length; i++) {
//			for (int j=0; j<scores[i].length; j++) {
//				System.out.print(scores[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		
		Scanner scanner = new Scanner(System.in);
		
		int studentNum;
		int courseNum;
		int[][]score;
		
		
		
			System.out.print("학생수를 입력하세요.>>");
			studentNum = scanner.nextInt();
			System.out.print("과목수를 입력하세요.>>");
			courseNum = scanner.nextInt();
			
			score = new int[studentNum][courseNum];
			
			for(int i=0; i<studentNum; i++) {
				for(int j=0; j<courseNum; j++) {
					System.out.print(i+"번 과목"+j+"번째 점수 입력>>");
					score[i][j]=scanner.nextInt();
				}
			}
			for(int i=0; i<score.length; i++) {
				for(int j=0; j<score[i].length; j++) {
					System.out.print(score[i][j]+"\t");
				}
				System.out.println();
			}
		scanner.close();
		
		
		

	}

}
