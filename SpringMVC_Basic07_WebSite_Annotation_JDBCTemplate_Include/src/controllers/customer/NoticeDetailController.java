package controllers.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.NoticeDao;
import vo.Notice;


/*
 * 게시판 목록조회
 * 
 */
public class NoticeDetailController implements Controller{

private NoticeDao noticedao;
	
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	public NoticeDetailController() {
		System.out.println("[NoticeDetailController]");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String seq = request.getParameter("seq");
		Notice notice = noticedao.getNotice(seq);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("notice", notice);
		mv.setViewName("noticeDetail.jsp");
		
		
		return mv;
	}

}
