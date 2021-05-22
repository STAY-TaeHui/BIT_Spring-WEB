
//활용 : awt , swing , android (event 처리) :버튼 클릭 , 마우스 오버 , 

//익명 클래스, Anonymous Class

//클래스를 정의하지 않고 객체를 정의하는 방법 > 1회용 클래스 사용 > 재사용이 불가능한 클래스(객체를 1번 만드는 용도)

//이벤트 객체, 스레드 개체, 람다식, 스트림 등에서 사용.

//inner class
//클래스안에 클래스가 있다
class OuterClass {
	public int pdata = 10;
	private int data = 30;

	// inner class (자원에 대한 접근을 편하게)
	// member field 가 선언되는 곳에
	class InnerClass {
		void msg() {
			System.out.println("outerclass data : " + data);
			System.out.println("outerclass data : " + pdata);
		}
	}
}

/////////////////////////////////////////////
abstract class Person2 { // 강제적 구현
	abstract void eat();
}

class Man extends Person2 {

	@Override
	void eat() {
		System.out.println("person2 의 eat 함수 재정의");
	}

}

//////////////////////////////////////////////
interface Eatable {
	void eat();
}

class Test {
	void method(Eatable e) {
		e.eat();
	}
}
/*
 * class TTT implements Eatable{
 * 
 * @Override public void eat() { System.out.println("aaaaaa");
 * 
 * }
 * 
 * } Test t = new Test(); t.method(new TTT());
 * 
 */

public class Ex10_InnerClass {
	public static void main(String[] args) {
		OuterClass outobj = new OuterClass();
		System.out.println("public :" + outobj.pdata);

		OuterClass.InnerClass innerobj = outobj.new InnerClass();
		innerobj.msg(); // outer 클래스에 대한 자원 접근 용이

		Man m = new Man();
		m.eat();
		Person2 p2 = m;
		p2.eat();

		Person2 p3 = new Man();
		p3.eat();

		// abstract class Person2 어차피 강제 구현을 목적으로
		// 추상클래스는 객체 생성 불가능
		// Person2 상속하는 클래스 없이도 1회성으로 사용가능한 클래스 (이름이 없는 클래스) : 익명클래스


		Person2 p4 = new Person2() {
			@Override
			void eat() {
				System.out.println("익명 타입으로 구현");
			}
		};

		p4.eat();

		// Today POINT  주로 사용하는 방법
		Test t = new Test();
		t.method(null);
		
//		t.method(new Eatable() {
//			@Override
//			public void eat() {
//				
//				System.out.println("일회성 자원으로 인터페이스를 직접 구현");
//			}
//		});
		/*
		 * t.method(new Eatable() {
		 * 
		 * @Override public void eat() { System.out.println("일회성 자원으로 인터페이스를 직접 구현");
		 * 
		 * } });
		 */

	}

}
