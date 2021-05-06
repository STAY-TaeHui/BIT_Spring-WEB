package com.model;

//DTO
//DB에 테이블이 있다고 가정하고 연습 >> 1:1로 매핑되는 클래스



public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
