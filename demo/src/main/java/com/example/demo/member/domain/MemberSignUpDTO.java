package com.example.demo.member.domain;

import java.util.Date;

public class MemberSignUpDTO {
	
	private String userName;
	private String passWord;
	private String checkPassword;
	private String email;
	
	
	

	public MemberSignUpDTO(String userName, String passWord, String checkPassword, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.checkPassword = checkPassword;
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberSignUpDTO [userName=" + userName + ", passWord=" + passWord + ", checkPassword=" + checkPassword
				+ ", email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberSignUpDTO() {
		super();
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
	public String getCheckPassword() {
		return checkPassword;
	}
	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}



	
	
}
