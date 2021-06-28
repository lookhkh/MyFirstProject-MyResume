package com.example.demo.member.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class RefBoardDTO {

	
	public Long bno; //자동
	public String userName; //성함
	public String relationship; //관계
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date registerDate;// 등록일 // 자동
	public String title; //제목
	public String content; //글 내용
	
	
	
	
	
	public RefBoardDTO(Long bno, String userName, String relationship, Date registerDate, String title,
			String content) {
		this.bno = bno;
		this.userName = userName;
		this.relationship = relationship;
		this.registerDate = registerDate;
		this.title = title;
		this.content = content;
	}
	
	
	
	public RefBoardDTO() {
	}



	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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



	@Override
	public String toString() {
		return "RefBoardDTO [bno=" + bno + ", userName=" + userName + ", relationship=" + relationship
				+ ", registerDate=" + registerDate + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
