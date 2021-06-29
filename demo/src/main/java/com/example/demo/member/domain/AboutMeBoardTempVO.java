package com.example.demo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class AboutMeBoardTempVO {

	private String bno;
	private String title;
	private String content;
	private MultipartFile file;
	
	
	
	public AboutMeBoardTempVO() {
		super();
	}
	public AboutMeBoardTempVO(String bno, String title, String content, MultipartFile file) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.file = file;
	}
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "AboutMeBoardTempVO [bno=" + bno + ", title=" + title + ", content=" + content + ", file=" + file + "]";
	}
	
	
}
