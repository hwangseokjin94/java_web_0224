<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <% 
    	request.setCharacterEncoding("utf-8");
    
    	String site = request.getParameter("site");
    	
    	
    
    	response.sendRedirect(site);/* 주소를 다시알려주는 방식 */
    	
    	
    	//request.getRequestDispatcher(site).forward(request, response);
    	/*  밑에랑 위에랑 다름
    	서버내 다른 파일 /폴더로 이동하는것으로 인식하기 떄문에 이동이되지 않는다.
    	포어드는 폴더내에서..?
    			*/
    %>
