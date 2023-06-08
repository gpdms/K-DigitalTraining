package chap10_1212;

public class ArrayIndexEx {

	public static void main(String[] args) {
		
		if(args.length == 1) {
			String data1 = args[0]; //위에 있는 args
		System.out.println(data1); //run configurations-arguments에서 입력
		} else {
			System.out.println("args[0]에 값 없음");
		}
	}

}
