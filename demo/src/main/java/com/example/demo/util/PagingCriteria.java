package com.example.demo.util;

public class PagingCriteria {

	private int pageNum;
	private int amount;
	private String rel;
	
	public PagingCriteria(int pageNum){
		this.pageNum=pageNum;
		this.amount = 5;
		this.rel = null;
	}
	
	
	public PagingCriteria(int pageNum, String rel){
		this.pageNum=pageNum;
		this.amount = 5;
		this.rel = rel;
	}
	
	public PagingCriteria() {
		this.pageNum=1;
		this.amount=5;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getRel() {
		return rel;
	}


	public void setRel(String rel) {
		this.rel = rel;
	}


	@Override
	public String toString() {
		return "PagingCriteria [pageNum=" + pageNum + ", amount=" + amount + ", rel=" + rel + "]";
	}

	
	
}
