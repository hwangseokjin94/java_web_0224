package common;

public class PageVO {

	// Field
	
	// 게시물 : record
	// 페이지 : page
	// 블록   : block
	
	// record 가 3개 모이면 1 page
	// page 가 3개 모이면 1 block
	
	private int totalRecord = 0;  // 전체게시물
	private int recordPerPage = 3;  // 한 페이지에 표시할 게시물 개수
	private int totalPage = 0;  // 전체 페이지 개수
	private int page = 1;  // 현재 페이지 번호 (파라미터가 없을 때 기본으로 사용하기 위해서 1 페이지로 저장한다.)
	private int beginRecord = 0;  // 한 페이지에 표시할 시작 게시물 번호
	private int endRecord = 0;  // 한 페이지에 표시할 종료 게시물 번호
	
	private int pagePerBlock = 3;  // 한 블록에 표시할 페이지 개수
	private int beginBlock = 0;  // 한 블록에 표시할 시작 페이지 번호
	private int endBlock = 0;  // 한 블록에 표시할 종료 페이지 번호
	
	
	// Method
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	
	
	// "전체 페이지 개수" 스스로 계산이 가능하다.
	public void setTotalPage() {
		totalPage = totalRecord / recordPerPage;
		if (totalRecord % recordPerPage != 0) {
			totalPage++;
		}
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(int beginRecord) {
		this.beginRecord = beginRecord;
	}
	public int getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(int endRecord) {
		this.endRecord = endRecord;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBeginBlock() {
		return beginBlock;
	}
	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
}