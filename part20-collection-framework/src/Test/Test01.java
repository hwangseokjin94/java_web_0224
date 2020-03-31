package Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Board
class Board {
	
	// Field
	private String title;
	private String content;
	private Date registerDate;		// 현재 날짜 자동 삽입
	
	// Constructor
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
		this.registerDate = new Date();
	}
	
	// Method
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sb.append("제목: ").append(title).append("\n");
		sb.append("내용: ").append(content).append("\n");
		sb.append("등록일: ").append(sdf.format(registerDate)).append("\n");
		return sb.toString();
	}
	
}



public class Test01 {

	public static void main(String[] args) {
		
		List<Board> list = new ArrayList<Board>();
		
		list.add( new Board("공지", "공지 내용") );
		list.add( new Board("알림", "알림 내용") );
		list.add( new Board("요청", "요청 내용") );
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 게시글 번호 >> ");
		int idx = sc.nextInt();
		
		if (idx <= list.size()) {
			list.remove(idx - 1);
		}
		
		System.out.println(list);
		
		sc.close();

	}

}