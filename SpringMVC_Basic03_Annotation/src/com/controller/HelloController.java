package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * 이전에 작업했던.... handleRequest함수를 만들어 쓰는 방식은
 * 단점 : 서비스요청 개수만큼 controller 생성
 * 게시판 : 목록보기 >> listController
 * 		  글쓰기 >> writeController
 * 
 * 
 * 대안은 : @Controller >> method 단위로 service 매핑
 	하나의 controller안에서
 * 게시판 : 목록보기 >> list()
 * 		  글쓰기 >> write()
 * */

@Controller
public class HelloController {
	public HelloController() {
		System.out.println("HelloController 생성자 호출");
	}
	
	@RequestMapping("/hello.do")  // <a href="hello.do"></a>
	public ModelAndView hello() {
		System.out.println("[hello.do method call]");
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("greeting", getGeeting());
		mav.setViewName("Hello");
		
		return mav;
	}
	
	@RequestMapping("/hi.do")
	public ModelAndView hi() {
		System.out.println("[this is hi.do]");
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("string", "HI!!");
		mv.setViewName("Hello");
		return mv;
	}
	
	
	private String getGeeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data = "";
		if(hour >= 6 && hour <= 10) {
			data = "학습시간";
		}else if(hour >= 11 && hour <= 13) {
			data = "배고픈 시간";
		}else if(hour >= 14 && hour <= 18) {
			data = "졸린 시간";
		}else {
			data = "go home";
		}
		
		return data;
		
	}


}
