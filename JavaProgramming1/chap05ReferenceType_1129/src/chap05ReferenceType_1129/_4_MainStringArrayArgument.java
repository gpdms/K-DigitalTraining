package chap05ReferenceType_1129;

public class _4_MainStringArrayArgument {
 
									//괄호안을 커맨드라인 arguments라고함. main메소드의 매개값
	public static void main(String[] args) {
		//명령프롬프트에 cd + bin까지 파일경로 복붙 엔터, java 패키지면/클래스명, 10 20 적어주면 결과값나옴.
		//혹은 Run-Run Configurations-Arguments에 입력값 10 20 입력
	
		
		if(args.length != 2) {
			System.out.println("프로그램의 사용법");
			System.out.println("java MainStringArrayArgument num1 num2");
			System.exit(0); //종료시켰기때문에 아래 코드까지 가지 못하고 여기서 종료. 아래코드를 위로 올리면 실행됨.
		}
	
			for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
			
			
		String strNum1 = args[0];
		String strNum2 = args[1];
		
		int num1 = Integer.parseInt(strNum1); //문자열을 정수로 변환
		int num2 = Integer.parseInt(strNum2);
		
		int result = num1 + num2;
		System.out.println(num1+"+"+num2+"+"+result);

	}

}
