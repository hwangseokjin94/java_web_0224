package command.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import common.Command;
import dto.memberDTO;

public class LogoutCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		//session 에 저장된 로그이 유저의 정보를 삭제
		HttpSession session = request.getSession();
		memberDTO loginDTO = (memberDTO)session.getAttribute("loginDTO");
		
		ActionForward actionForward = new ActionForward();
		
		
		if(loginDTO != null) {
			//session 초기화
			session.invalidate();
			actionForward.setPath("index.jsp");
			actionForward.setRedirect(true);
			
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out= response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert<'로그인된 회원의 정보가 없습니다'>;");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		return actionForward;
	}

}
