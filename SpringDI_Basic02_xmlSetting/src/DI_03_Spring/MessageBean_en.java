package DI_03_Spring;

public class MessageBean_en implements MessageBean{

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("Hello " + name + " !");
	}

}
