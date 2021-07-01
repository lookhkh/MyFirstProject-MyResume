package com.example.demo.member.domain;

import java.util.Date;

public class RefBoardReply {
	
	private Long bno;
	private Long rno;
	private String writer;
	private String content;
	private Long up;
	private Long down;
	private Date register;
	private Long root;
	public Long getBno() {
		return bno;
	}
	public void setBno(Long bno) {
		this.bno = bno;
	}
	public Long getRno() {
		return rno;
	}
	public void setRno(Long rno) {
		this.rno = rno;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUp() {
		return up;
	}
	public void setUp(Long up) {
		this.up = up;
	}
	public Long getDown() {
		return down;
	}
	public void setDown(Long down) {
		this.down = down;
	}
	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
	public Long getRoot() {
		return root;
	}
	public void setRoot(Long root) {
		this.root = root;
	}
	@Override
	public String toString() {
		return "RefBoardReply [bno=" + bno + ", rno=" + rno + ", writer=" + writer + ", content=" + content + ", up="
				+ up + ", down=" + down + ", register=" + register + ", root=" + root + "]";
	}
	public RefBoardReply(Long bno, Long rno, String writer, String content, Long up, Long down, Date register,
			Long root) {
		super();
		this.bno = bno;
		this.rno = rno;
		this.writer = writer;
		this.content = content;
		this.up = up;
		this.down = down;
		this.register = register;
		this.root = root;
	}
	public RefBoardReply() {
		super();
	}
	
	
	
}
