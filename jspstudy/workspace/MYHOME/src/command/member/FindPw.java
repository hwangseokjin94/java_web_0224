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
import dto.MemberDTO;

@WebServlet("/FindPw.member")
public class FindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindPw() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 전달 받은 파라미터 저장 ( data: 'mId=' + $('#mId').val() + ... )
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		String mPhone = request.getParameter("mPhone");
		
		// 2. mId + mPhone = Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("mId", mId);
		map.put("mPhone", mPhone);
		
		// 3. Map 정보를 가진 회원 검색
		MemberDTO mDTO = MemberDAO.getInstance().selectBymIdmPhone(map);
		
		// 4. 결과 (responseText) 생성
		String responseText = null;
		if ( mDTO == null ) {
			responseText = "NO";
		} else {
			responseText = "YES";
		}
		
		// 5. 결과를 응답 (response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(responseText);  // findPwPage.jsp 의 success: function(responseText) { } 의 매개변수로 결과를 전달(응답)한다.
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








