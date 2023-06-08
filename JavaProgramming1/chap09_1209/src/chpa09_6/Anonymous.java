package chpa09_6;

public class Anonymous {
	private int field;
	
	public void method(int arg1, int arg2) {
		int var1 = 0;
		int var2 = 0;
		field = 10;
		
//		arg1 = 20; 
//		var1 = 30; 
		
		
		Calculatable calc = new Calculatable() {

			@Override
			public int sum() {
				int result = field + arg1 + arg2 + var1 + var2;
				return result;
			}
		};
		
		System.out.println(calc.sum());
	}
}
