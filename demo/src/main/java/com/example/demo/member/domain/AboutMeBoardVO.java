package com.example.demo.member.domain;

public class AboutMeBoardVO {
	private Long bno;
	private String title;
	private String content;
	private String imgpath;
	public AboutMeBoardVO(Long bno, String title, String content, String imgpath) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.imgpath = imgpath;
	}
	public AboutMeBoardVO() {
	}
	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
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
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}


	
	
	
	
}
