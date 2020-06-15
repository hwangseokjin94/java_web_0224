package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import common.Command;
import dao.MemberDAO;
import dto.MemberDTO;

public class LoginCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setmId(mId);
		mDTO.setmPw(mPw);
		
		MemberDTO loginDTO = MemberDAO.getInstance().selectBymIdmPw(mDTO);
		
		ActionForward actionForward = new ActionForward();
		
		HttpSession session = null;
		
		if (loginDTO != null) {
			session = request.getSession();
			session.setAttribute("loginDTO", loginDTO);  // 로그인에 성공하면 회원정보가 session 에 저장된다.
			actionForward.setPath("index.jsp");
			actionForward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('제출된 정보와 일치하는 회원이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;
		
	}

}
