package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DTO;

public class GradeCommand {

	public String execute(HttpServletRequest request , HttpServletResponse response) {
		DTO dto = new DTO();
		dto.setName(request.getParameter("name"));
		dto.setKor(Integer.parseInt(request.getParameter("kor")));
		dto.setEng(Integer.parseInt(request.getParameter("eng")));
		dto.setMat(Integer.parseInt(request.getParameter("mat")));
		int kor =Integer.parseInt(request.getParameter("kor"));
		int eng =Integer.parseInt(request.getParameter("eng"));
		int mat =Integer.parseInt(request.getParameter("mat"));
		double avg =(kor+eng+mat)/3.0;
		dto.setAvg(avg);
		char grade;
		if(avg>=90) {
			grade = 'A';
		}else if(avg >=80) {
			grade = 'B';
		}else if(avg >=70) {
			grade = 'C';
		}else if(avg >=60) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		
		
		dto.setGrade(grade);
		
		
		
		request.setAttribute("DTO", dto);
		return "output.jsp";
		
	}
	
	
	
}
