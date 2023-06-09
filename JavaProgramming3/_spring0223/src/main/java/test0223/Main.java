package test0223;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		Aaa g1 = ctx.getBean("aaa", Aaa.class);
		Aaa g2 = ctx.getBean("aaa", Aaa.class);
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();
	}
}
