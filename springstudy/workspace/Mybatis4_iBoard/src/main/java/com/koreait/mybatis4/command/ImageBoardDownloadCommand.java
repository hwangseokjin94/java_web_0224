package com.koreait.mybatis4.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

public class ImageBoardDownloadCommand implements ImageBoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		
		// 1. 서버에 파일이 저장되어 있는 위치를 알아낸다.
		String realPath = request.getSession().getServletContext().getRealPath("/resources/storage");
		
		// 2. 다운로드 받을 파일 이름은 request 에 iFilename 으로 저장되어 있다.
		String iFilename = request.getParameter("iFilename");
		
		// 업로드 할 때 파일 : car.jpg
		// iFilename         : car_111111111111.jpg
		
		// 3. 업로드 할 때의 파일 이름으로 다운로드 할 파일 이름을 결정해 둔다.
		String extName = iFilename.substring(iFilename.lastIndexOf(".") + 1);  // 확장자만 빼 두기
		String downloadFilename = iFilename.substring(0, iFilename.lastIndexOf("_")) +
								  "." + extName;
		
		// 4. 다운로드 할 파일을 연결한다.
		File file = new File(realPath, iFilename);  // (경로, 파일명)
		
		// 5. 다운로드(=파일복사)에 필요한 스트림을 생성한다.
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			
			// 6. 다운로드가 되는 response 를 만든다.
			response.setHeader("Content-Type", "application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(URLEncoder.encode(downloadFilename, "utf-8")).replaceAll("\\+", " "));
			response.setHeader("Content-Length", file.length() + "");
			
			// 7. 스트림을 생성한다.
			// 1) 입력스트림 : 서버에 저장된 파일
			// 2) 출력스트림 : 다운로드 받는 클라이언트 (response)
			bis = new BufferedInputStream(new FileInputStream(file));  // file 은 서버에 있다.
			bos = new BufferedOutputStream(response.getOutputStream());
			
			// 8. 입력스트림 -> 출력스트림 : 파일복사
			FileCopyUtils.copy(bis, bos);
			
			// 9. 혹시 출력스트림에 남아 있는 게 있으면 다 보내버리기
			bos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) { bos.close(); }
				if (bis != null) { bis.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
