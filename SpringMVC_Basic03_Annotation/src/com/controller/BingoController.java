package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BingoController {
	public BingoController() {
		// TODO Auto-generated constructor stub
		System.out.println("Bingo 생성자 호출");
	}
	
	@RequestMapping("/bingo.go")
	public ModelAndView bingo() {
		System.out.println("[this is bingo.do]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("bingo", "bingo");
		mv.setViewName("Hello");
		
		return mv;
	}
}
