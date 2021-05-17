package kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import dto.EmpDto;
import service.EmpService;

@RestController   //@Controller + @ResponseBody
public class AjaxRestController {

	@Autowired
	private EmpService empservice;
	
	@RequestMapping(value="restcon.ajax")
	public List<EmpDto> ajaxResponseBody(){
		//@RestController를 붙이면
		//@ResponseBody를 붙이지 않아도 JSON으로 반환해준다.
		List<EmpDto> list = empservice.getEmpList();
		return list;  
	}
	
	
	@RequestMapping(value="view.ajax")
	public String ViewPage(){//converter에 의해서 문자열 전달(비동기)
		System.out.println("view.ajax");
		//ModelAndView mv = new ModelAndView("view.jsp"); 
		return "view.jsp 문자열 리턴";
	}
	
	
	
}
