package DI_Annotation_02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {
	

	private Recorder recorder;
	
	
	 public MonitorViewer() {
		 System.out.println("constructor"); 
	}
//	@Qualifier >> 여기에 넣을꺼면 필드에 넣어줘야함 
//	 public MonitorViewer(@Qualifier("recorder_1")Recorder recorder) {
//		 System.out.println("constructor"); 
//	}
	
	public Recorder getRecorder() {
		return recorder;
	}
	
	
	// setter 통해서 Recorder 객체의 주소를 자동으로 주입 
	// By Type 이 컨테이너 안에 있으면 ..
	@Autowired(required = false) // false면 xml에 원하는 Qualifier가 없어도 null로 설정하고 진행
	@Qualifier("yy")/*  <qualifier value="recorder_1"></qualifier>  */
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;
	}
	
	@Autowired
	@Qualifier("recorder_2")
	public void Gmethod(Recorder rec) {
		System.out.println("Gmethod (rec) : " + rec);
	}
	
	
	
}
