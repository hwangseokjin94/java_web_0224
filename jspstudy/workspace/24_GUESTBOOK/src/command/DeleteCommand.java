package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GuestbookDAO;

public class DeleteCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int no =Integer.parseInt(request.getParameter("no"));
		int result = GuestbookDAO.getInstance().deleteDTO(no);
		
		ActionForward actionForward =new ActionForward();
		if(result > 0) {
			actionForward.setPath("/24_GUESTBOOK/listPage.guest");
			actionForward.setRedirect(true); //DB가저장되면 redirect 
		}else {
			//경고창 등답을 위해 response에스트림을 생성한다.
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('방명록삭제되지 않았습니다. 다시시도해주세요')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return actionForward ;
	}

}
