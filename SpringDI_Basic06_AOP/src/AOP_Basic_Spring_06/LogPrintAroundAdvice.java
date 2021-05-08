package AOP_Basic_Spring_06;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;



public class LogPrintAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Aroud Advice invoke Start");
		System.out.println("method : " + method);
		
		//보조업무
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		
		//주업무(실 객체의 함수를 호출)
		Object result = method.proceed();
		
		
		//보조업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : " + method+ "]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis() + "]");
		
		return result;
	}



}
