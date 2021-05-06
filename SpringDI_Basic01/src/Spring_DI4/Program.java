package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
//		1. SpringFramwork가 제공하는 컨테이너 안에 객체생성(메모리공간:IOC컨테이너)
 		2. 컨테이너를 만들고 그 메모리에 필요한 객체를 생성하고 조립(주입) >> 소멸
 
		
//		NewRecordView view = new NewRecordView();
//		NewRecord record = new NewRecord();
//		
//		
//		view.setRecord(record); //setter 주입(다형성)
//		view.input();
//		view.print();
		*/
		
		//저장곤간인 컨테이너를 만들고 그 다음 xml read 한다. 그리고 컨테이너 안에 객체 생성, 주입 과정 실행
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		
		//컨테이너 안에서 필요한 객체만 골라서 가져오면됨
		RecordView view=  (RecordView)context.getBean("view");
		
		view.input();
		view.print();
		
		//예외
		//Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory
	}

}
