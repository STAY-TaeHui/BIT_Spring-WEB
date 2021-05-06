package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
public class HelloController implements Controller{

	public HelloController() {
		// TODO Auto-generated constructor stub
		System.out.println("HelloController 객체 생성");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello Controller 요청실행 : handleRequest 함수 실행");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("name", "bituser");// request.setAttribute("name", "bituser")이랑 같은코드
		mav.setViewName("Hello");
		//InternalResourceViewResolver에 의해서 view단의 주소가 조합된다.
		///WEB-INF/views/ + Hello + .jsp >> view의 주소
		return mav;
	}

}
