package com.service;

import com.model.NewArticleCommand;

public class ArticleService {
	public ArticleService() {
		// TODO Auto-generated constructor stub
		System.out.println("ArticleService생성자 호출");
	}
	
	public void writeArticle(NewArticleCommand command) {
		//DAO있다고 가정
		//insert 실행되었다고 가정
		
		System.out.println("글쓰기 작업 완료" + command.toString());
	}
}
