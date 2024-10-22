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

@WebServlet("/Leave.member")
public class Leave extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Leave() {
        super();
    }
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 전달 받은 파라미터 저장
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		
		// 2. mId 회원 삭제
		int result = MemberDAO.getInstance().deletemDTO(mId);
		
		// 3. 결과를 저장할 JSONObject 생성
		JSONObject obj = new JSONObject();
		
		// 4. JSONObject 에 결과 result 저장
		if (result > 0) {
			obj.put("result", "SUCCESS");
			request.getSession().invalidate();  // 세션 초기화
		} else {
			obj.put("result", "FAIL");
		}
	
		// 5. 응답 (response)
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
