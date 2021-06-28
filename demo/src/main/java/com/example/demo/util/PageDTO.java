package com.example.demo.util;

public class PageDTO {
	
	private boolean next, prev;
	private int startPage;
	private int endPage;
	private int total;
	private PagingCriteria cri;
	private int realEnd;
	
	public PageDTO(PagingCriteria cri, int total) {
		this.cri=cri;
		this.total=total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/5.0))*5;
		this.startPage = this.endPage-4;
		
		this.realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd<this.endPage) {
			this.endPage=realEnd;
		}

		this.prev = this.startPage>1;
		this.next = this.endPage<realEnd;
		
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public PagingCriteria getCri() {
		return cri;
	}

	public void setCri(PagingCriteria cri) {
		this.cri = cri;
	}

	
	
	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	@Override
	public String toString() {
		return "PageDTO [next=" + next + ", prev=" + prev + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", total=" + total + ", cri=" + cri + "]"+"realEnd "+realEnd;
	}
	
	
	
	
}
