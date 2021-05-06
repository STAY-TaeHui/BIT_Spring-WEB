package DI;

public class NewRecordView {
	//점수 출력하는 클래스
	
	//복합연관 >> 어떤 클래스 두개가 있을때(has a)를 통해 서로 라이프사이클이 같을때
	private NewRecord record;
	public NewRecordView(int lor, int eng, int math) {
		record = new NewRecord(lor, eng, math);
	}
	public void print() {
		System.out.println(record.total() + "/" + record.avg());
	}
}
