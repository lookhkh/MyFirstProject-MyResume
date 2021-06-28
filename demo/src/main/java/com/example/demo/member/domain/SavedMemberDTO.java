package com.example.demo.member.domain;

import java.util.List;

public class SavedMemberDTO {

	private String userName;
	private String passWord;
	private String Email;
	private MemberAuthorization auth;
	
	public SavedMemberDTO() {

	}

	
	public SavedMemberDTO(String userName, String passWord, String email, MemberAuthorization auth) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.Email = email;
		this.auth = auth;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public MemberAuthorization getAuth() {
		return auth;
	}

	public void setAuth(MemberAuthorization auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return "SavedMemberDTO [userName=" + userName + ", passWord=" + passWord + ", Email=" + Email + ", auth=" + auth
				+ "]";
	}
	
	
	
	
}
