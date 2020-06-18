package dto;

import java.sql.Date;

public class boardDTO {
	private int bNo,mNo,bHit,bRef,bStep,bDepth,bDelete;
	private String bTitle,bContent,bPw,bIp;
	private Date bRegdate;
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getmNo() {
		return mNo;
	}
	public void setmNo(int mNo) {
		this.mNo = mNo;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public int getbRef() {
		return bRef;
	}
	public void setbRef(int bRef) {
		this.bRef = bRef;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbDepth() {
		return bDepth;
	}
	public void setbDepth(int bDepth) {
		this.bDepth = bDepth;
	}
	public int getbDelete() {
		return bDelete;
	}
	public void setbDelete(int bDelete) {
		this.bDelete = bDelete;
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
	public String getbPw() {
		return bPw;
	}
	public void setbPw(String bPw) {
		this.bPw = bPw;
	}
	public String getbIp() {
		return bIp;
	}
	public void setbIp(String bIp) {
		this.bIp = bIp;
	}
	public Date getbRegdate() {
		return bRegdate;
	}
	public void setbRegdate(Date bRegdate) {
		this.bRegdate = bRegdate;
	}
	
	
	
	
}
