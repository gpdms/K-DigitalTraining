package chap05ReferenceType_1129;

public class _6_ArrayCopy {

	public static void main(String[] args) {
		// 배열복사
		
		String[] oldStrArray = {"java", "array", "copy"};
		String[] newStrArray =  new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArray, 0, oldStrArray.length);
		
		for (int i=0; i<newStrArray.length; i++) {
			System.out.print(newStrArray[i] + ",");
		}

	}

}
