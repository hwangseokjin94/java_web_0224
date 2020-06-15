package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BBSDAO;
import dto.BBSDTO;

public class BBSDeleteCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward actionForward = new ActionForward();
	
		try {
		
			HttpSession session = request.getSession();
			BBSDTO bDTO = (BBSDTO) session.getAttribute("bDTO");
			
			int result = BBSDAO.getInstance().deleteBBS(bDTO.getbNo());
			
			if (result > 0) {
				actionForward.setPath("/25_BBS/listPage.bbs?page=" + request.getParameter("page"));
				actionForward.setRedirect(true);  // redirect (DB가 수정되었으므로)
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script type='text/javascript'>");
				out.println("alert('게시글이 삭제되지 않았습니다. 다시 시도하세요.')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}
			
		} catch (Exception e) {
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글이 삭제되지 않았습니다. 다시 시도하세요.')");
			out.println("history.go(-2)");
			out.println("</script>");
			out.close();
			
		}
		
		return actionForward;
		
	}

}