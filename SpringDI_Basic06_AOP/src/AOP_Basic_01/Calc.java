package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {
	/*
	 * 간단한 사칙계산기 프로그램
	 * -주관심 : 사칙연산
	 * 보조관심 : 연산에 걸리는 시간
	 * -log 출력
	 */
	
	public int Add(int x, int y) {
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무
		int result = x+y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : Add]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis() + "]");
		return result;
	}
	public int Mul(int x, int y) {
		
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");
		
		//주업무
		int result =x*y;
		
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time Log Method : Mul]");
		log.info("[Time log Method : " + sw.getTotalTimeMillis() + "]");
		return result;
	}
}
