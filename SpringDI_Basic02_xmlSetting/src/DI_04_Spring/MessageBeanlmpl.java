package DI_04_Spring;

public class MessageBeanlmpl implements MessageBean{

	private String name;
	private String greeting;
	
	public MessageBeanlmpl(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " " + this.greeting);
		
	}
	
}
