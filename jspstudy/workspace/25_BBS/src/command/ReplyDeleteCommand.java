package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;

public class ReplyDeleteCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		int rNo = Integer.parseInt(request.getParameter("rNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String page = request.getParameter("page");
		
		int result = ReplyDAO.getInstance().deleteReply(rNo);
		
		ActionForward actionForward = new ActionForward();
		
		if (result > 0) {
			actionForward.setPath("/25_BBS/viewPage.bbs?bNo=" + bNo + "&page=" + page);
			actionForward.setRedirect(true);  // redirect
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('댓글을 삭제할 수 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;

	}

}
