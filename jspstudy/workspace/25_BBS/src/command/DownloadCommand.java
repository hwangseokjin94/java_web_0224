package command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadCommand {

	public static void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String bFilename = request.getParameter("bFilename");
		
		final String DIRECTORY = "storage";
		String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
		
		File file = new File(realPath + "/" + bFilename);
		
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(bFilename, "utf-8"));
		response.setHeader("Content-Length", file.length() + "");
		
		// 다운로드 
		// 파일 종류 : 텍스트 파일 (문자 기반 스트림 : FileReader, BufferedReader, FileWriter, BufferedWriter, PrintWriter)
		// 파일 종류 : 나머지 모든 파일 (바이트 기반 스트림 : FileInputStream, BufferedInputStream, FileOutputStream, BufferedOutputStream)
		
		BufferedInputStream bis = null;  // 다운로드 할 파일을 읽는다.
		BufferedOutputStream bos = null;  // 읽은 내용을 새로운 파일로 만든다.
		
		bis = new BufferedInputStream( new FileInputStream(file) );
		bos = new BufferedOutputStream( response.getOutputStream() );
		
		byte[] byteArray = new byte[1024];  // 1024바이트 = 1KB
		while ( (bis.read(byteArray)) != -1 ) {
			bos.write(byteArray);
		}
		
		if (bos != null) { bos.close(); }
		if (bis != null) { bis.close(); }
		
	}

}
