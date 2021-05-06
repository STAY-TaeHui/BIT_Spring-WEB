package DI_02;

public class HelloApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageBean_en messageBean_en = new MessageBean_en();
		MessageBean_kr messageBean_kr = new MessageBean_kr();
		
		MessageBean messagebean= new MessageBean_en();
		messagebean.sayHello("hong");
		
		messagebean=new MessageBean_kr();
		messagebean.sayHello("안녕");
	}

}

/*
	요구사항
	1. 한글버전 (hong) : 안녕 hong
	2. 영문버전 (hong) : hello hong
	
*/