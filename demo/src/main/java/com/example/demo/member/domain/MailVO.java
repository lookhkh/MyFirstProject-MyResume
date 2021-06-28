package com.example.demo.member.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.jetbrains.annotations.NotNull;

public class MailVO {

	@NotBlank
	@NotNull("title is mandatory")
	private String who;
	@Length(min = 10, max =11,message = "전화번호 형식에 맞추어 다시 작성해주세오")
	@NotNull("invalid argument")
	private String contactInfo;
	@NotBlank
	@NotNull("invalid argument")
	private String title;
	@NotBlank
	@NotNull("invalid argument")
	private String content;
	
	
	
	public MailVO() {
	}
	
	
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
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
		return "MailVO [who=" + who + ", contactInfo=" + contactInfo + ", title=" + title + ", content=" + content
				+ "]";
	}
	
	
}
