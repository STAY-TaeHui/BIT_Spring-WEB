package AOP_Basic_02_JAVA;

import java.lang.reflect.Proxy;

public class Program {

	public static void main(String[] args) {
		//1. 실 객체의 주소
		Calc calc = new NewCalc();
		
		//2. 가짜를 생성할 것
		Calc cal=(Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(),//실 객체의 메타정보
								calc.getClass().getInterfaces(),
								new LogPrintHandler(calc));
		
		int result = cal.ADD(5, 10);
		System.out.println("result : " + result);
		
		result = cal.MUL(10, 5);
		System.out.println("result : " + result);

		result = cal.SUB(10, 5);
		System.out.println("result : " + result);

	}

}
