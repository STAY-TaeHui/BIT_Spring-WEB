package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//
//@Getter 
//@Setter
//@AllArgsConstructor 모든 멤버필드 생성자
//@ToString			  
//@NoArgsConstructor  디폴트 생성자
@Data
public class Emp {
	private int empno;
	private String enmae;
}
