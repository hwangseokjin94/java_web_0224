package command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadCommand  {

	
	public static void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String bfilename= request.getParameter("bfilename");
		
		final String DIRECTORY ="storage";
		String realPath =request.getServletContext().getRealPath("/"+DIRECTORY);
		
		
		File file = new File(realPath+"/"+bfilename);
		
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(bfilename, "utf-8"));
		response.setHeader("Content-Length",  file.length()+"");
		
		//다운로드
		//파일 종류 : 텍스트 파일 (문자기반스트림 : FileReader,Bufferedreader , FileWriter,BufferedWriter , PrintWriter)
		//파일종류 : 나머지 모든파일 (바이트 기반 스트림 FileInputStream ,BufferedInputStream,  FileOutputStream , BufferedOutputStream )
		
		BufferedInputStream bis = null; // 다운로드할 파일을 읽는다.
		BufferedOutputStream bos = null;//읽은 내용을 새로운 파일로 만든댜
		
		bis = new BufferedInputStream(new FileInputStream(file));
		bos = new BufferedOutputStream( response.getOutputStream() );
		
		byte[] byteArray = new byte[1024]; //1024바이트  = 1KB
		while( (bis.read(byteArray)) != -1) {
			bos.write(byteArray);
		}
		if(bos != null){bos.close();}
		if(bis != null){bis.close();}
		
		
	
	}

}
