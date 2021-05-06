package DI_Annotation_01;

import org.springframework.beans.factory.annotation.Autowired;

public class MonitorViewer {
	@Autowired // 생성자 자동호출. 생성자가 없다면 기본 생성자 자동생성.
				//오버로딩 생성자가 있다면 에러
				//둘다있다면 상관없음
	private Recorder recorder;
	
	
	public MonitorViewer() {
		System.out.println("constructor");
	}
//	public MonitorViewer(Recorder recorder) {
//		System.out.println("constructor2");
//		this.recorder = recorder;
//	}
	
	
	public Recorder getRecorder() {
		return recorder;
	}
	
	// setter 통해서 Recorder 객체의 주소를 자동으로 주입 
	// By Type 이 컨테이너 안에 있으면 ..
	
	// @Autowired(required = true) defalut >> 무조건 injection 하겠다.
	// @Autowired(required = false) >> 컨테이너안에 원하는 타입이 없으면 안한다.
	
	
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	
	
}
