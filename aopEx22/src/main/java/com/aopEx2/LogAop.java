package com.aopEx2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //Aspect 역할을 할 클래스라고 명시해줌
public class LogAop {

	//Pointcut이라고 명시된 메서드가 필요
	//@Pointcut의 속성에 핵심코드의 어느 부분까지 공통기능을 사용하겠다고 명시
//	@Pointcut("within(com.aopEx2.*)")
//	private void pointcutMethod(){ 
//		System.out.println("this is PointCut");
//	}
	
	@Around("execution(* SUB(..))")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		//공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
		String signatureStr = joinpoint.getSignature().toShortString();
		
		//공통기능
		//System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
		
		try {
			System.out.println(signatureStr + "........................시작"); //메서드 실행

			Object obj = joinpoint.proceed(); //핵심 기능 실행	
			
			System.out.println(signatureStr + "........................끝");

			return obj;
		}
		finally {
			//공통기능
			//System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
			
		}
	}
	
	@Before("NewCalc.SUB()")
	public void beforeMethod(JoinPoint joinpoint){
		System.out.println("........................@BEFORE");
	}
	@After("execution(* SUB(..))")
	public void AfterMethod(){
		System.out.println("........................@AFTER");
	}
//	@AfterThrowing("excution(* MUL(..))")
//	public void AfterThrowing() {
//		System.out.println("........................@AFTER Throwing");
//	}

}
