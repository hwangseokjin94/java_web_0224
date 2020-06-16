package command.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import dao.MemberDAO;
import dto.MemberDTO;

 
@WebServlet("/SignUp.member")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SignUp() {
        super();
      
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //1.전달받은 파라미터 -> MemberDTO 생성
		request.setCharacterEncoding("utf-8");
		MemberDTO mDTO = new MemberDTO();
				
		mDTO.setmId(request.getParameter("mId"));
		mDTO.setmPw(request.getParameter("mPw"));
		mDTO.setmName(request.getParameter("mName"));
		mDTO.setmEmail(request.getParameter("mEmail"));
		mDTO.setmPhone(request.getParameter("mPhone"));
		mDTO.setmAddress( request.getParameter("mAddress"));
		
		//2.생성된 membredto저장
		int result = MemberDAO.getInstance().insertmDTO(mDTO);
		
		//3결과를 저장할 JSONObject 생성
		JSONObject obj = new JSONObject();
		if(result>0) {
			obj.put("result", "SUCCESS"); //obj = {"result" :"SUCCESS"}
		}else {
			obj.put("result", "FAIL");
		}
		
		//4.결과응답
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(obj);
		out.close();
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		doGet(request, response);
	}

}
