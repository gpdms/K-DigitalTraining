package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class); //@Configuration안에 있는 @Bean 객체생성(?)
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		System.out.println("(g1 == g2) = " + (g1 == g2)); //객체를 두개 만든건지 하나만든건지 확인. 싱글톤인지 확인. 둘이 같음 싱글톤임.
		ctx.close();
	}
}
