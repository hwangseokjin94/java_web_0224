package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BBSDAO;
import dto.BBSDTO;

public class BBSInsertCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		final String DIRECTORY = "storage";
		String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
		
		MultipartRequest mr = new MultipartRequest(
									request,
									realPath,
									1024 * 1024 * 10,  // 10MB
									"utf-8",
									new DefaultFileRenamePolicy());
		
		// request -> mr -> DTO
		BBSDTO bDTO = new BBSDTO();
		bDTO.setbWriter( mr.getParameter("bWriter") );
		bDTO.setbTitle( mr.getParameter("bTitle") );
		bDTO.setbContent( mr.getParameter("bContent") );
		bDTO.setbPw( mr.getParameter("bPw") );
		if ( mr.getFile("bFilename") != null ) {
			bDTO.setbFilename(mr.getFilesystemName("bFilename"));
		} else {
			bDTO.setbFilename("");
		}
		bDTO.setbIp( request.getRemoteAddr() );
		
		int result = BBSDAO.getInstance().insertBBS(bDTO);
		ActionForward actionForward = new ActionForward();
		
		if (result > 0) {
			actionForward.setPath("/25_BBS/listPage.bbs");
			actionForward.setRedirect(true);  // redirect (DB가 수정되었으므로)
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글이 작성되지 않았습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;
	}

}