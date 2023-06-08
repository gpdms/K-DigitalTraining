package chap05ReferenceType_1129;

public class _3_Array {

	public static void main(String[] args) {
		// 배열타입 선언 여러방법
		
		// 배열과 값 함께 선언
		int[] arr1 = {1,2,3};
		int arr2[] = {1,2,3};
		System.out.println(arr1[0]);
		System.out.println(arr2); //배열전체출력은안됨???
		
		//배열먼저 선언후 후에 값
		int[] arr3;
		arr3= new int[] {1,2,3};
		
		//배열길이 선언후 후에 값
		int[] arr4 = new int[4];
		arr4[0] = 1;
		
		for (int i=0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		
		System.out.println(sum(arr3));
	}
	
	public static int sum (int arr[]) {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

}
