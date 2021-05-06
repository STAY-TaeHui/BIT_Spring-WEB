package DI2;

public class NewRecordView {
	//점수 출력하는 클래스
	
	//복합연관 >> 어떤 클래스 두개가 있을때(has a)를 통해 서로 라이프사이클이 같을때
	private NewRecord record;//member field >> setter를 이용하여 만들것
	
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	//1. [생성자]를 통해서 필요한 객체를 생성 or 주입 >> DI(Defendency Injection) >> 복합, 집합 >> 생성자이기때문에 무조건 생성됨
	//2. 함수(setter)를 통해서 필요한 객체를 주입 >> DI(Defendency Injection) >> 집합 >> 필요에따라서 쓸수도 있고 아닐수도 있다.(융통성있음)

	public void print() {
		System.out.println(record.total() + "/" + record.avg());
	}
}
