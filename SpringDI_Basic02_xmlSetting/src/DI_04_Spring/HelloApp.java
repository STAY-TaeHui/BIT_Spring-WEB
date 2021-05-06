package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//JAVA코드
		//MessageBeanlmpl messagebean = new MessageBeanlmpl("hong");
		//messagebean.setGreeting("hello");
		//객체를 생성하고 주입하는 코드를 모두 xml로 넣어라
		
		//messagebean.sayHello();
		
		//Spring 코드
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		
		MessageBean messagebean= context.getBean("m4", MessageBean.class);
		messagebean.sayHello();

	}

}
