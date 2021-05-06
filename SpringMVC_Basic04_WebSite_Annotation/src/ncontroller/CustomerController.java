package ncontroller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("[CustomerController 생성자]");
	}
	
	private NoticeDao noticedao;
	
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	/*
	  1. method안에서 return type [String] >> 리턴값이 뷰의 주소
	  
	  2. public ModelAndView notices .... > ModelAndView 객체 생성 > 데이터, 뷰 설정 > return 
	  
	  3. public String notices(Model model) >> 내부적으로 Model객체의 주소가 들어온다.
	  
	  
	
	*/
	
	/*
	@RequestMapping("/customer/notice.htm")                             // /customer/notice.htm?pg=1&f="title"
	public ModelAndView notices(String pg , String f , String q) {
		
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
						list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
		//Spring  적용
		ModelAndView   mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("notice.jsp");
		return mv;
	}
	*/
	/*
	@RequestMapping("customer/notice.htm")
	public ModelAndView notices(@RequestParam(value ="pg",defaultValue = "1")String pg,
			@RequestParam(value = "f", defaultValue = "Title") String title,
			@RequestParam(value = "p", defaultValue = "%%") String p) throws ClassNotFoundException, SQLException {
		
		 List<Notice> list = noticedao.getNotices(Integer.parseInt(pg),title, p);
		 
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("list", list);
		 mv.setViewName("notice.jsp");
		return mv;
	}*/
	
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q, Model model) {
		
		//default 값 설정
		int page = 1;
		String field="TITLE";
		String query = "%%";
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}

		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
						list = noticedao.getNotices(page, field, query);
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		
//		//Spring  적용
//		ModelAndView   mv = new ModelAndView();
//		mv.addObject("list", list);
//		mv.setViewName("notice.jsp");
//		return mv;
		model.addAttribute("list", list); // 자동으로 notice.jsp forward
		
		return "notice.jsp";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticesDetail(String seq, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = noticedao.getNotice(seq);
		
//		ModelAndView mv = new ModelAndView();
//		
//		mv.addObject("notice", notice);
//		mv.setViewName("noticeDetail.jsp");
		
		model.addAttribute("notice",notice);
		return "noticeDetail.jsp";
	}
	
	//글쓰기 화면(GET)
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	//글쓰기 처리(POST)
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.POST)
	public String noticeReg(Notice n) {// 오버로딩!!
		System.out.println(n.toString());
		return null;
	}
	
	//글수정하기(화면 > 데이터 뿌려주고)GET
	//굴수정(처리) POST
	
}
