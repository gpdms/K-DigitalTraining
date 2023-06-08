package chap01;

import java.util.Scanner;

public class MyGameUpDown {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		//20이하 숫자 중 하나 랜덤배정
		int random = (int)(Math.random()*30+1);
		int i;
		boolean run = true;
		while(run) {
			System.out.print("1이상 30이하의 숫자 중 하나를 고르세요.>>");
			for(i=0; i < 5; i++) {
				
				int input = scan.nextInt();
				
				if (input == random) {
					System.out.print("정답입니다. 게임을 종료합니다.");
					run = false;
				} else if (input < random) {
					System.out.println("UP");
				} else {
					System.out.println("DOWN");
				}}
				System.out.println("틀렸습니다. 게임을 종료합니다.");
				run = false;
			} 
		}	
	}


