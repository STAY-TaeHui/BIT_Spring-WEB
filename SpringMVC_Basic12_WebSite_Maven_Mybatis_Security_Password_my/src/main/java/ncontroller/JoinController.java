package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	private MemberDao memberdao;
	
//	mapper로 작성한 DAO는 Injection이 필요가 없다.
//	@Autowired
//	public void setMemberdao(MemberDao memberdao) {
//		this.memberdao = memberdao;
//	}
	
	///////////////////////////////////////////////////////
	//암호화
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    /////////////////////////////////////////////////////// 
	
	//회원가입 페이지 요청(GET)
	@RequestMapping(value="join.htm", method=RequestMethod.GET)
	public String join() {
		
		return "joinus/join";
	}
	
	//회원가입 처리(POST)
	@RequestMapping(value="join.htm", method=RequestMethod.POST)
	public String join(Member member) {
		System.out.println(member.toString());
		
		String viewpage = "";
		//회원가입 : 암호 1004
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		////////////////////////////////////////////////////////////////// 이거 한줄 끝
		
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
	
	//로그인 요청
	@RequestMapping(value="login.htm", method=RequestMethod.GET)
	public String login() {
		return "joinus/login";
	}
	//로그인 처리는 Spring이 자동화처리
}
