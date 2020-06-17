package command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/Update.member")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Update() {
        super();
    }
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. request -> mDTO
		request.setCharacterEncoding("utf-8");
		MemberDTO mDTO = new MemberDTO();
		mDTO.setmId(request.getParameter("mId"));
		mDTO.setmName(request.getParameter("mName"));
		mDTO.setmEmail(request.getParameter("mEmail"));
		mDTO.setmPhone(request.getParameter("mPhone"));
		mDTO.setmAddress(request.getParameter("mAddress"));
		
		// 2. 수정
		int result = MemberDAO.getInstance().updatemDTO(mDTO);
		
		// 3. 결과를 저장할 JSONObject 생성
		JSONObject obj = new JSONObject();
		
		// 4. obj에 결과 저장
		if (result > 0) {
			HttpSession session = request.getSession();
			MemberDTO loginDTO = MemberDAO.getInstance().selectBymId(request.getParameter("mId"));  // 정보가 수정된 회원
			session.removeAttribute("loginDTO");
			session.setAttribute("loginDTO", loginDTO);
			obj.put("result", "SUCCESS");
		} else {
			obj.put("result", "FAIL");
		}
		
		// 5. 응답
		// response.setHeader("Content-Type", "application/json; charset=utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
