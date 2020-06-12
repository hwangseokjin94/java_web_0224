package command;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.GuestbookDAO;
import dto.GuestbookDTO;

public class InsertCommand implements GuesbookCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//파일이 업로드될 디렉코리
		final String DIRECTORY ="storage";
		
		//업로드될 디렐토리의 실제경로
		String realPath =request.getServletContext().getRealPath("/"+DIRECTORY);
		
		//MultipartRequest 객체선언
		MultipartRequest mr = null;
		//새로운 리퀘스투
		mr = new MultipartRequest(request, 
									realPath,
									1024*1024*10,
									"utf-8",
									new DefaultFileRenamePolicy()
									);
		
		//DB에저장할 GuestbookDTO 객체생성
		GuestbookDTO gDTO = new GuestbookDTO();
		gDTO.setWriter(mr.getParameter("writer"));
		gDTO.setEmail(mr.getParameter("email"));
		gDTO.setPw(mr.getParameter("pw"));
		gDTO.setTitle(mr.getParameter("title"));
		gDTO.setContent(mr.getParameter("content"));
		
		if(mr.getFile("filename") != null) { //첨부된 파일이 있는경우
			gDTO.setFilename(mr.getFilesystemName("filename")); //서버에저장된 파일명을 DB에저장한다다다.
			
		}else {//첨부파일이 없는경우
			gDTO.setFilename("");
		}
		
		
		//DAO 에게 DTO를 전달하면 DAO는 mapper를 불러서 DTO를저장시킨다.
		//DB에 수정사항이 생귄뒤에는 언제나 forward로 이동한다.
		//성공실패 메시지도 함께출력한다.
		int result = GuestbookDAO.getInstance().insertDTO(gDTO);
		ActionForward actionForward = new ActionForward();
	
		if(result > 0) {
			actionForward.setPath("/24_GUESTBOOK/listPage.guest");
			actionForward.setRedirect(true); //redirect
		}else {
			//경고창 등답을 위해 response에스트림을 생성한다.
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('방명록작성되지 않았습니다. 다시시도해주세요')");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		
		return actionForward;
	}

}














