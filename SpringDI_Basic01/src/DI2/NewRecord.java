package DI2;

//vo, dto, domain 의미를 갖는 클래스(데이터를 담을 수 있는 클래스)
public class NewRecord {
	private int lor;
	private int eng;
	private int math;
	public NewRecord() {}
	
	public NewRecord(int lor, int eng, int math) {
		super();
		this.lor = lor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getLor() {
		return lor;
	}
	public void setLor(int lor) {
		this.lor = lor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	///////////////////////////
	//필요에 따라서 함수 추가 구현가능
	public int total() {
		return this.lor+this.eng+this.math;
	}
	public float avg() {
		return total()/3.0f;
	}
	
}
