package AOP_Basic_02_JAVA;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

//보조업무를 가지고 있는 클래스(공통관심)
//실 함수를 대신해서 처리할 수 있는 기능( 대리함수 ) : invoke
public class LogPrintHandler implements InvocationHandler{
	private Object target;//실 객체의 주소값
	public LogPrintHandler(Object target) {
		System.out.println("logPrintHandler 생성자가 호출");
		this.target = target;
	}

	//invoke 함수가 대리함수(Add, Mul, Sub)들을 대신하는 함수
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoeke 함수호출");
		System.out.println("method 명 + " +method);
		System.out.println("method parameter : " + Arrays.toString(args));
		
		//보조업무
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무 실행 ( 실객체의 실 함수 호출)
		int result = (int)method.invoke(this.target, args);
		
		//보조업무
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : " + method+ "]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis() + "]");
		return result;
	}

}
