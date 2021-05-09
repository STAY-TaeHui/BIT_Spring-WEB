package com.aopEx2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		//bean을 설정한 xml파일이 있는 위치를 지정하여 설정파일을 얻어옴
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationCtx.xml");
		
		//설정파일에서 bean을 가져옴
		Calc newCalc = ctx.getBean("newCalc",Calc.class);

		int result = newCalc.ADD(10000, 10000);
		System.out.println("AOP 결과 : " + result);
		result = newCalc.SUB(10000, 50);
		System.out.println("AOP 결과 : " + result);
		result = newCalc.MUL(10, 20);
		
		   // int result = calc.SUB(100, 50);
		    System.out.println("AOP 결과 : " + result);
	}
}
