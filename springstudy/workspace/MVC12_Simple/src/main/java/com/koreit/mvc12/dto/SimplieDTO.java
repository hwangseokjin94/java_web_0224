package com.koreit.mvc12.dto;

import java.sql.Date;

public class SimplieDTO {

	private int bNo;
	private String bWriter ,bTitle,bContent;
	private Date bDate;
	
	public SimplieDTO() {}

	public SimplieDTO(int bNo, String bWriter, String bTitle, String bContent, Date bDate) {
		super();
		this.bNo = bNo;
		this.bWriter = bWriter;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbWriter() {
		return bWriter;
	}

	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Date getbDate() {
		return bDate;
	}

	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	
}
