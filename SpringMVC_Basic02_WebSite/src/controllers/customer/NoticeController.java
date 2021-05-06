package controllers.customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;


/*
 * 게시판 목록조회
 * 
 * controller -> Model 의존 (DAO, DTO)가 필요
 * 
 * NoticeController는 NoticeDAO에 의존한다.
 */
public class NoticeController implements Controller{
	public NoticeController() {
		System.out.println("[NoticeController]");
	}
	
	private NoticeDao noticedao;
	
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//DAO객체 사용
		//public List<Notice> getNotices(int page, String field, String query)
		
		String _page=request.getParameter("pg");
		String _field=request.getParameter("f");
		String _query=request.getParameter("p");
		
		//default값 설정
		int page=1;
		String field="Title";
		String query = "%%";
		if(_page!=null && _page.equals("")) {
			page=Integer.parseInt(_page);
		}
		if(_field!=null && _field.equals("")) {
			field=_field;
		}
		if(_query!=null && _query.equals("")) {
			query=_query;
		}
		
		//DAO작업
		 List<Notice> list = noticedao.getNotices(page,field, query);
		 
		 //Spring적용
		 ModelAndView mv = new ModelAndView();
		 mv.addObject("list", list);
		 mv.setViewName("notice.jsp");
		
		
		return mv;
		
		
	}

}
