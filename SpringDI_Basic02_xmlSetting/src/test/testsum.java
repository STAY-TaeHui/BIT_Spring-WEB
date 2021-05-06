package test;

public class testsum implements test {

	private int a;
	private int b;
	
	
	public void setA(int a) {
		this.a= a;
	}
	public void setB(int b) {
		this.b= b;
	}
	
	@Override
	public void sum() {
		// TODO Auto-generated method stub
		System.out.println("a : " + a + " b : " + b);
		
	}

}
