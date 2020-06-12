package dto;

import java.sql.Date;

public class ReplyDTO {
	private int rNo, bNo;
	private String rWriter, rContent, rPw, rIp;
	private Date rRegdate;
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public String getrWriter() {
		return rWriter;
	}
	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public String getrPw() {
		return rPw;
	}
	public void setrPw(String rPw) {
		this.rPw = rPw;
	}
	public String getrIp() {
		return rIp;
	}
	public void setrIp(String rIp) {
		this.rIp = rIp;
	}
	public Date getrRegdate() {
		return rRegdate;
	}
	public void setrRegdate(Date rRegdate) {
		this.rRegdate = rRegdate;
	}
}
