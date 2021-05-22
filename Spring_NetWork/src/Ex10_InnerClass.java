
//Ȱ�� : awt , swing , android (event ó��) :��ư Ŭ�� , ���콺 ���� , 

//�͸� Ŭ����, Anonymous Class

//Ŭ������ �������� �ʰ� ��ü�� �����ϴ� ��� > 1ȸ�� Ŭ���� ��� > ������ �Ұ����� Ŭ����(��ü�� 1�� ����� �뵵)

//�̺�Ʈ ��ü, ������ ��ü, ���ٽ�, ��Ʈ�� ��� ���.

//inner class
//Ŭ�����ȿ� Ŭ������ �ִ�
class OuterClass {
	public int pdata = 10;
	private int data = 30;

	// inner class (�ڿ��� ���� ������ ���ϰ�)
	// member field �� ����Ǵ� ����
	class InnerClass {
		void msg() {
			System.out.println("outerclass data : " + data);
			System.out.println("outerclass data : " + pdata);
		}
	}
}

/////////////////////////////////////////////
abstract class Person2 { // ������ ����
	abstract void eat();
}

class Man extends Person2 {

	@Override
	void eat() {
		System.out.println("person2 �� eat �Լ� ������");
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
		innerobj.msg(); // outer Ŭ������ ���� �ڿ� ���� ����

		Man m = new Man();
		m.eat();
		Person2 p2 = m;
		p2.eat();

		Person2 p3 = new Man();
		p3.eat();

		// abstract class Person2 ������ ���� ������ ��������
		// �߻�Ŭ������ ��ü ���� �Ұ���
		// Person2 ����ϴ� Ŭ���� ���̵� 1ȸ������ ��밡���� Ŭ���� (�̸��� ���� Ŭ����) : �͸�Ŭ����


		Person2 p4 = new Person2() {
			@Override
			void eat() {
				System.out.println("�͸� Ÿ������ ����");
			}
		};

		p4.eat();

		// Today POINT  �ַ� ����ϴ� ���
		Test t = new Test();
		t.method(null);
		
//		t.method(new Eatable() {
//			@Override
//			public void eat() {
//				
//				System.out.println("��ȸ�� �ڿ����� �������̽��� ���� ����");
//			}
//		});
		/*
		 * t.method(new Eatable() {
		 * 
		 * @Override public void eat() { System.out.println("��ȸ�� �ڿ����� �������̽��� ���� ����");
		 * 
		 * } });
		 */

	}

}