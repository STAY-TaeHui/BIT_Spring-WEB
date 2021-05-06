package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class introController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("introController 요청실행 : handleRequest함수 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "hong");
		
		mav.setViewName("intro");
		
		return mav;
	}
	
}
