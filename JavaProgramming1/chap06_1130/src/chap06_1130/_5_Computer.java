package chap06_1130;

public class _5_Computer {
	
	int sum1 (int[] values) {
		int sum = 0;
		for (int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	//위와 아래 같음.
	int sum2 (int ... values)	{
		int sum = 0;
		for(int i=0; i<values.length; i++)	{
			sum += values[i];
		}
		return sum;
	}
}
