package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.ReplyDTO;

public class ReplyInsertCommand implements BBSCommand {

	public  ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		ReplyDTO rDTO = new ReplyDTO();
		rDTO.setbNo(Integer.parseInt(request.getParameter("bNo")));
		rDTO.setrPw(request.getParameter("rPw"));
		rDTO.setrContent(request.getParameter("rContent"));
		rDTO.setrWriter(request.getParameter("rWriter"));
		rDTO.setrIp( request.getRemoteAddr() );

		int result= ReplyDAO.getInstance().insertReply(rDTO);
		ActionForward actionForward =  new ActionForward();
		
		if(result >0 ) {
			actionForward.setPath("/25_BBS/viewPage.bbs?bNo="+rDTO.getbNo()+"&page="+request.getParameter("page"));
			actionForward.setRedirect(true);//redirect						
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('작성할수.. 없습니다.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;
	}
}