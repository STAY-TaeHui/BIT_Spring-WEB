package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*
	- 클라이언트 요청
	1. 화면주세요(글쓰기, 로그인하기) : write.do
	2. 처리해주세요(글쓰기 입력 처리, 로그인 완료 처리) : writeok.do
	
	요청주소가 : write.do >> 화면보여달라
	요청주소가 : writeok.do >> 처리해라
	
	클라이언트 요청 주소 1개를 가지고 나눠서
	요청주소 하나로 (화면, 처리) 판단 >> 근거는 >> GET, POST 둘중하나
	>> http://localhost~~~~/article/newArticle.do 일때
	
	전송바익이
	1. GET >> 화면 >> VEIW 제공
	2. POST >> 서비스 처리 >> INSERT, UPDATE 처리
  
*/
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	private ArticleService articleservice;
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
				
	}
	@RequestMapping(method=RequestMethod.GET)//newArticle.do에서 전송방식이 GET으로 들어온다면!!
	public String form() {// 함수의 return type이 String이면 view의 주소라고 하자!!(약속) disaptcher에서 
		return "article/newArticleForm";
	}
	/*
	가장 전통적인 방법
	@RequestMapping(method=RequestMethod.POST)// 전송방식이 POST로 들어온다면!!(service 처리)
	public ModelAndView submit(HttpServletRequest request) {
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		//NewArticleController 가 service 필요해
		this.articleservice.writeArticle(article);
		//처리완료
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		return mv;
	}
	*/
	
	//2. Spring에서 parameter를 DTO객체로 받기
	//2.1 자동화 >> input name="" 값이 DTO객체의 member field명과 동일해야함(대소문자까지)
	
	/*
	@RequestMapping(method=RequestMethod.POST)// 전송방식이 POST로 들어온다면!!(service 처리)
	public ModelAndView submit(NewArticleCommand command) {
		//1. 자동으로 DTO객체 생성 >> NewArticleCommand command = new NewArticleCommand
		//2. 넘어온 parameter값이 setter를 통해서 자동 주입
		//3. NewArticleCommand객체가 IOC컨테이너 안에 자동 생성 >> id값이 자동 >> id="newArticleCommand"
		
		//NewArticleController 가 service 필요해
		this.articleservice.writeArticle(command);
		//처리완료
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("ArticleCommand", command);
		mv.setViewName("article/newArticleSubmitted");
		return mv;
	}
	*/
	
	
	
	@RequestMapping(method=RequestMethod.POST)// 전송방식이 POST로 들어온다면!!(service 처리)
	//public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
	public String submit(NewArticleCommand command) {

		//NewArticleController 가 service 필요해
		this.articleservice.writeArticle(command);
		//처리완료
		
		//view페이지에서 데이터를 어떻게 받냐??
		//NewArticleCommand객체가 IOC컨테이너 안에 자동 생성 >> id값이 자동 >> id="newArticleCommand"
		//자동으로 forward가 일어난다. >> view에서 객체이름을 뭐로 받냐?? >> newArticleCommand (key)값이다~!!!

		return "article/newArticleSubmitted";
	}
}
