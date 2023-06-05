package test0223;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		Aaa g = ctx.getBean("aaa", Aaa.class);
		g.setSs("연습");
		String msg = g.getSs();
		System.out.println(msg);
		ctx.close();
	}
}
