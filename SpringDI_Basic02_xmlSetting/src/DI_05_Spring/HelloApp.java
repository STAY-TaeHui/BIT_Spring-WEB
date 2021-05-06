package DI_05_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
		//java 코드
		MyBean mybean= new MyBean();
		MyBean mybean2 = new MyBean("hong");
		MyBean mybean3 = new MyBean();
		System.out.println("mybean : " + mybean);
		//mybean : DI_05_Spring.MyBean@7637f22
		System.out.println("mybean2 : " + mybean2);
		//mybean2 : DI_05_Spring.MyBean@4926097b
		System.out.println("mybean3 : " + mybean3);
		//mybean3 : DI_05_Spring.MyBean@762efe5d
		
		Singleton single = Singleton.getInstance();
		Singleton single2 = Singleton.getInstance();
		System.out.println("single : " + single);
		//single : DI_05_Spring.Singleton@41a4555e
		System.out.println("single2 : " + single2);
		//single : DI_05_Spring.Singleton@41a4555e
		*/
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_05_Spring/DI_05.xml");
		//스프링 컨테이너(메모리) 가 구성되고 xml 파일 read(파싱) 해서 객체 생성 , 조립 , 소멸 담당
		//컨테이너 안에서 필요한 객체를 얻어서 사용
		
		MyBean mybean = context.getBean("mybean", MyBean.class);
		MyBean mybean2 = context.getBean("mybean", MyBean.class);
		MyBean mybean3 = context.getBean("mybean", MyBean.class);
		//질문
		//mybean    mybean2    mybean3  변수가 가지는 주소값을 같을 까요 ,,,, 다를 까요
		System.out.println("주소값 : " + mybean + " : " + mybean2  + " : " + mybean3);
		//주소값 : DI_05_Spring.MyBean@69e1dd28 : DI_05_Spring.MyBean@69e1dd28 : DI_05_Spring.MyBean@69e1dd28
		
		//getBean()  
		//1. return type Object  (타입에 맞는 castring)
		//2.호출시 새로운 객체를 만들지 않아요 (new 하지 않아요)
		//3. 만들어져있는 객체를 가져와서 다시 쓰는것이다.
		//** 스프링 컨테이너 안에 객체들의 타입은 : default singleton
		//**예외적으로 getbean() 객체를 생성하게 할 수 있다 (거의 쓰지 않는다)
		
		MyBean mybean4 = context.getBean("mybean2", MyBean.class);
		System.out.println("생성자 사용 : " + mybean4);
		
		
		Singleton single = context.getBean("single",Singleton.class);
		Singleton single2 = context.getBean("single",Singleton.class);
		
		System.out.println(single + " / " + single2);
	}

}
