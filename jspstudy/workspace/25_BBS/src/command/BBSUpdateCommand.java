package command;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BBSDAO;
import dto.BBSDTO;

public class BBSUpdateCommand implements BBSCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 새로운 첨부파일이 등록될 수 있으므로 MultipartRequest 가 필요하다.
		
		final String DIRECTORY = "storage";
		String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
		
		MultipartRequest mr = new MultipartRequest(request, realPath, 1024 * 1024 * 10, "utf-8", new DefaultFileRenamePolicy());
		
		// 세션
		HttpSession session = request.getSession();
		BBSDTO bDTO2 = (BBSDTO) session.getAttribute("bDTO");
		
		// 수정할 내용을 담고 있는 bDTO 생성
		BBSDTO bDTO = new BBSDTO();
		bDTO.setbNo( bDTO2.getbNo() );
		bDTO.setbTitle( mr.getParameter("bTitle") );
		bDTO.setbContent( mr.getParameter("bContent") );
		bDTO.setbIp( request.getRemoteAddr() );
		bDTO.setbWriter( bDTO2.getbWriter() );
		bDTO.setbHit( bDTO2.getbHit() );
		bDTO.setbPw( bDTO2.getbPw() );
		bDTO.setbRegdate( bDTO2.getbRegdate() );
		
		// 기존 첨부 여부에 따른 첨부 처리
		
		// 새로 첨부할 파일
		File newFile = mr.getFile("bFilename");
		
		// 기존 첨부된 파일
		String oldFile = bDTO2.getbFilename();
		
		// 기존 첨부와 새로운 첨부가 모두 있으면, 기존 첨부 파일을 서버에서 삭제하겠다.
		if (newFile != null && oldFile != null) {
			File file = new File(realPath + "/" + oldFile);
			file.delete();
		}
		
		// 새로운 첨부가 있으면 해당 정보를 bDTO에 저장
		// 새로운 첨부 여부에 따라 호출하는 DAO의 메소드가 다르다.
		int result = 0;
		if ( newFile != null ) {
			bDTO.setbFilename( mr.getFilesystemName("bFilename") );
			result = BBSDAO.getInstance().updateBBSWithFile(bDTO);
		} else {
			bDTO.setbFilename( bDTO2.getbFilename() );
			result = BBSDAO.getInstance().updateBBS(bDTO);
		}
		
		ActionForward actionForward = new ActionForward();
		
		// viewPage.jsp 로 전달할 page 정보
		String page = mr.getParameter("page");
		
		if (result > 0) {
			session.removeAttribute("bDTO");
			session.setAttribute("bDTO", bDTO);
			actionForward.setPath("bbs/viewPage.jsp?page=" + page);
			actionForward.setRedirect(true);  // redirect (DB가 수정되었으므로)
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('게시글이 수정되지 않았습니다. 다시 시도하세요.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return actionForward;
		
	}

}

