package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestbookDAO;
import dto.GuestbookDTO;

public class ViewCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		
		GuestbookDTO gDTO =GuestbookDAO.getInstance().selectByNo(no);
		request.setAttribute("gDTO", gDTO);
		
		ActionForward actionForward = new ActionForward();
		if(gDTO != null) {
			actionForward.setRedirect(false); //forward (안해도되는 작업 )
			actionForward.setPath("/guestbook/viewPage.jsp");
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('방명록을 열수없습니다.. 다시시도해주세요')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		
		return actionForward;
	}

}
