package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MessageBean_en messageBean_en = new MessageBean_en();
//		MessageBean_kr messageBean_kr = new MessageBean_kr();
//		
//		MessageBean messagebean= new MessageBean_en();
//		messagebean.sayHello("hong");
//		
//		messagebean=new MessageBean_kr();
//		messagebean.sayHello("안녕");
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		//Generic .... 형변환의 이점
		MessageBean message = context.getBean("messagebean", MessageBean.class);
		message.sayHello("hello");
	}

}

/*
	요구사항
	1. 한글버전 (hong) : 안녕 hong
	2. 영문버전 (hong) : hello hong
	
*/