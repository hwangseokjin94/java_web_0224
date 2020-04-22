package run;

import java.sql.ResultSet;
import java.util.Scanner;

import dao.MemberDao;
import dto.MemberDto;

public class MemberManager {
	// Field
	private MemberDao mDao = new MemberDao();
	private Scanner sc = new Scanner(System.in);

	// method
	// 1.메뉴
	public void menu() {
		System.out.println();
		System.out.println("1.회원가입");
		System.out.println("2.회원탈퇴");
		System.out.println("3.회원수정");
		System.out.println("4.회원검색");
		System.out.println("5.프로그램종료");
		System.out.println();
	}

	// 2.회원가입
	public void insert() throws Exception {
		System.out.println("========회원가입==========");

		System.out.print("아이디 입력>>>>>>>>");
		String mId = sc.next();

		System.out.print("비빌번호 입력>>>>>");
		String mPw = sc.next();
		System.out.print("비빌번호 확인>>>>>");
		String mPw2 = sc.next();

		System.out.print("이름 입력>>>>>>>>>");
		String mName = sc.next();
		System.out.print("이메일  입력>>>>>");
		String mEmail = sc.next();

		ResultSet rs1 = mDao.selectBymId(mId);
		ResultSet rs2 = mDao.selectBymEmail(mEmail);
		if (rs1.next()) {
			System.out.println(mId + "이미 가입된 아이디 입니다.");
		} else if (rs2.next()) {
			rs2 = mDao.selectBymEmail(mEmail);
			System.out.println(mEmail + "이미가입된 이메일입니다");
		} else if (!mPw.equals(mPw2)) {
			System.out.println("비밀번호의 입력이 다릅니다.");
		} else {
			//DB로 보낼 DTO생성
			MemberDto mDto =new MemberDto();
			mDto.setmId(mId);
			mDto.setmPw(mPw);
			mDto.setmName(mName);
			mDto.setmEmail(mEmail);
			//생성된 DTO를 DB에전달
			mDao.insert(mDto);
			//mDao.insert(mId, mPw, mName, mEmail);
			System.out.println(mId + "님 회원가입되었습니다.");
		}

	}

	// 3.회원탈퇴
	public void delete() throws Exception {
		System.out.println("========회원탈퇴======");
		System.out.println("탈퇴할아이디 입력");
		String mId = sc.next();
		ResultSet rs = mDao.selectBymId(mId);
		if (rs.next()) {
			System.out.println("탈퇴하시겠습니까? (Y/N)>>>>");

			String yesNo = sc.next();
			if (yesNo.equalsIgnoreCase("Y") || yesNo.equalsIgnoreCase("YES")) {// "Y"," y""yes""YES"
				mDao.delete(mId);
				System.out.println("그 동안 이용해주셔서 감사합니다.");
			} else {
				System.out.println("탈퇴가 취소되었습니다.");
			}
		} else {
			System.out.println(mId + "님의 회원정보가 없습니다.");
		}
	}

	// 4.회원정보 수정
	public void update() throws Exception {

		System.out.println("======= 회원 정보수정 ======");
		System.out.print("수정할 아이디 입력 >>>>");
		String mId = sc.next();

		ResultSet rs = mDao.selectBymId(mId);
		//rs에는 한명의 member정보가 저장되어있다.
		//rs.getInt(1) ==rs.getInt("mNo")
		//rs.getString(2) == rs.getString("mId")
		//rs.getString(3) == rs.getString("mPw")
		//rs.getString(4) == rs.getString("mName")
		//rs.getString(5) == rs.getString("mEmail")
		//rs.getString(6) == rs.getString("mRegdate")

		if (rs.next()) {

			System.out.println("1. 비밀번호 수정");
			System.out.println("2. 이메일 수정");
			System.out.println("3. 비밀번호 +이메일수정");
			System.out.print("수정할 내용 작업선택>>");
			int cmd =sc.nextInt();
			
			//db로 보낼 DTO생성 
			MemberDto mDto = new MemberDto();
			mDto.setmId(mId);
			
			switch(cmd) {
			case 1 : 
				System.out.println("새 비밀번호 입력 >>>>");
				String mPw = sc.next();
				//DTO에 데이터저장
				mDto.setmPw(mPw);
				mDto.setmEmail(rs.getString("mEmail"));
				mDao.update(mDto);
				System.out.println(mId+"님의 비밀번호가 수정되었습니다.");
				break;
			case 2 :
				System.out.println("새 이메일 입력 >>>>");
				String mEmail = sc.next();
				mDto.setmPw(rs.getString("mPw"));
				mDto.setmEmail(mEmail);
				mDao.update(mDto);
				System.out.println(mId+"님의 이메일 수정되었습니다.");
				break;
			case 3 :
				System.out.println("새 비밀번호 입력 >>>>");
				String mPw2 = sc.next();
				System.out.println("새 이메일 입력 >>>>");
				String mEmail2 = sc.next();
				mDto.setmPw(mPw2);
				mDto.setmEmail(mEmail2);
				mDao.update(mDto);
				
		
				System.out.println(mId+"님의 비밀번호와 이메일 수정되었습니다.");
				break;	
				default: System.out.println("잘못된선택이다");
				
			}
		} else {
			System.out.println(mId + "님의 회원정보가 없습니다.");
		}

	}
	//5.회원검색
	public void select() throws Exception{
		
		System.out.println("=============회원 검색 ==============");
		
		System.out.print("검색할 회원의 아이디나 또는 이메일 입력>>>>");
		String query = sc.next();
		
		ResultSet rs =mDao.selectBymIdmEmail(query);
		if(rs.next()) {
			System.out.println("==========검색=====");
			System.out.println(" > 아이디 : " + rs.getString(2).substring(0,2)+"****");
			System.out.println(" >  이름  : " + rs.getString(4));
			System.out.println(" > 이메일 : " + rs.getString(5));
			System.out.println(" > 가입일 : " + rs.getDate(6));
		}else {
			System.out.println(query+"검색결과가 없습니다.");
		}

		
		
		
		
		
	}
	
	

	
	// 실행
	public void manage() {
		try {
			while (true) {

				menu();

				System.out.println("선택");
				int choice = sc.nextInt();

				switch (choice) {
				case 1:
					insert();
					break;
				case 2:
					delete();
					break;
				case 3:
					update();
					break;
				case 4:
					select();
					break;
				case 5:
					System.out.println("프로그램을종료합니다");
					System.exit(0);
				default:
					System.out.println("잘못된메뉴입니다.");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
