package command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/EmailCheck.member")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmailCheck() {
        super();
    }
    @SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 전달되는 파라미터 저장
		request.setCharacterEncoding("utf-8");
		String mEmail = request.getParameter("mEmail");
		
		// 2. mEmail 를 가진 회원 정보 확인
		MemberDTO mDTO = MemberDAO.getInstance().selectBymEmail(mEmail);
		
		// 3. 응답할 JSONObject 객체 생성
		JSONObject obj = new JSONObject();
		
		// 4. mId 를 가진 회원이 있으면 obj 에 result 변수에 "EXIST" 저장
		//    mId 를 가진 회원이 없으면 obj 에 result 변수에 "" 저장
		if ( mDTO != null ) {
			obj.put("result", "EXIST");
		} else {
			obj.put("result", "");
		}
		
		// 5. obj 를 응답
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
