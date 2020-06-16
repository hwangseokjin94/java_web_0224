package command.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/ChangePw.member")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangePw() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 전달 받은 파라미터 저장 ( data: $('#f').serialize() )
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		// 2. mId + mPw = Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("mPw", mPw);
		
		// 3. mPw 변경
		int result = MemberDAO.getInstance().updatemPw(map);
		
		// 4. 결과 (responseText) 생성
		String responseText = null;
		if ( result > 0 ) {
			responseText = "SUCCESS";
		} else {
			responseText = "FAIL";
		}
		
		// 5. 결과를 응답(response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(responseText);
		out.close();
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
