package command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/FindId.member")
public class FindId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FindId() {
        super();
   
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.전달받은 파라미터 처리 (	data:'mEmail=' +$('#mEmail').val())
		request.setCharacterEncoding("utf-8");
		String mEmail = request.getParameter("mEmail");
		
		//2.mEmail을 가진 회원검색
		MemberDTO mDTO = MemberDAO.getInstance().selectBymEmail(mEmail);
		
		//3.결과 responseText생성
		String responseText = null;
		if(mDTO != null) {
			responseText = mDTO.getmId();
		}else {
			responseText ="NO";//이메일과 일치하는 회원이 없을떄 응답결과는 스스로정한다. 
		}
		
		//4.responseText를 전달(response)
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out= response.getWriter();
		out.println(responseText); //findIdPage.jsp의 success:function(responseText){}매개변수로 결과가 전달된다.
		out.close();
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
