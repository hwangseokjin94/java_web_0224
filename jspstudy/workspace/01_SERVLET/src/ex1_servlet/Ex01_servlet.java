package ex1_servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01_servlet
 */
@WebServlet("/Ex01_servlet")
public class Ex01_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     * 1.생성자  
     * 	  생성자가 호출된 뒤 init()메소드가 자동으로 호출된다.
     */
    public Ex01_servlet() {
        super();
        System.out.println("생성자 호출");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 * 2.init()메소드
	 * 		1)생성자가 호출된 뒤(서블릿이 생성된뒤) 한번만 호출된다.
	 * 		2)초기화 용도로 사용할수 있다.
	 * 		3)init() 메소드가 호출된 뒤 service()메소드가 자동ㅇ으로 호출된다.
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("init() 호출");
	}


	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 * 3.service()메소드
	 * 		1)실제 처리를 할 수 있다.
	 * 		2)매개변수-1
	 * 			(1) HttpServletRequest
	 * 			(2) 변수 :request
	 * 			(3) 사용자의 요청 정보가 저장된다.
	 * 				예) 로그인할떄 '아이디','비밀번호'를 입력하면 request 에 저장된다.
	 * 		3) 매개변수-2
	 * 			(1)타입: HttpServletResopnse
	 * 			(2)변수 : response
	 * 			(3)서버의 응답 정보가 저장된다.
	 *			     예) 검색결과는 response 에 저장된다.
	 *            								        	              
	 * 
	 *  				
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("service() 호출" );
		 if( request.getMethod().equalsIgnoreCase("GET") ) {
			 doGet(request,response);
		 }else {
			 doPost(request,response);
		 }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * 
	 * 4.doGet() 메소드
	 * 		1)method 가 지정되지않으면자동으로 호출된다.
	 * 		2)method ='get'으로 지정되면 자동으로 호출된다.
	 * 		3)get 방식이든 post 방식이든 실제로는 doGet()내부에서 처리하도록 구성되어있다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 5. doPost()메소드
	 * 		1)method ='post'으로 지정되면 자동으로 호출된다.
	 * 		2)실제 처리는 하지않고 ,모든 정보를 다시 doGet() 메소드로 넘기는 역활로 구현되고있다.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("doPost() 호출");
		doGet(request, response);
		//정보만담아노는 형식이고 한군데로 모으기때문  똑같은 코드 두번안적기 서버에서 처리하기 때문.
		
	}

	/**
	 * @see Servlet#destroy()
	 * 
	 * 6.destroy()메소드
	 * 		웹서버에서 프로젝트가 소멸되면 자동으로 호출된다.
	 */
	public void destroy() {
		System.out.println("destroy호출");
	}
}
