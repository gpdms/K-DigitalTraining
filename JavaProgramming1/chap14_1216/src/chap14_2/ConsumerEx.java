package chap14_2;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class ConsumerEx {

	public static void main(String[] args) {
//		Consumer<String> cos = t -> System.out.println(t + "8");
//		cos.accept("java");
		
		DoubleConsumer cos = t -> System.out.println(t + "8");
		cos.accept(333);
		
	}

}
