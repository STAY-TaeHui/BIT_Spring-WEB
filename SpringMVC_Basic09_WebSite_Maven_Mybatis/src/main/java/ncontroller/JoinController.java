package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	private MemberDao memberdao;
	
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao = memberdao;
	}
	
	//회원가입 페이지 요청(GET)
	@RequestMapping(value="join.htm", method=RequestMethod.GET)
	public String join() {
		
		return "joinus/join";
	}
	
	//회원가입 처리(POST)
	@RequestMapping(value="join.htm", method=RequestMethod.POST)
	public String join(Member member) {
		System.out.println(member.toString());
		
		try {
			memberdao.insert(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/index.htm";
		//   /index.htm (root 경로) 
		//  http://localhost:8080/SpringMVC_Basic06_WebSite_Annotation_JDBCTemplate/customer/notice.htm
		// >> http://localhost:8080/SpringMVC_Basic06_WebSite_Annotation_JDBCTemplate/index.htm
	}
}
