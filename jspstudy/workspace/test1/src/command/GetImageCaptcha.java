package command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GetImageCaptcha implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 네이버 캡차 API 예제 - 키발급
        String clientId = "RysvBcsu80140IlBnAK5";  // 애플리케이션 클라이언트 아이디값";
        String clientSecret = "YBFmPAzquL";  // 애플리케이션 클라이언트 시크릿값";

        try {
        	
        	/***** 1. 캡차 키 발급해 달라고 요청하기 *****/
        	
        	String code = "0"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅
        	String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;

        	URL url = new URL(apiURL);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        	
            conn.setRequestMethod("GET");
		    conn.setRequestProperty("X-Naver-Client-Id", clientId);
		    conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		    int responseCode = conn.getResponseCode();
		    String message = null;
		    if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                message = readBody(conn.getInputStream());
            } else { // 에러 발생
                message = readBody(conn.getErrorStream());
            }
		    //S ystem.out.println(message);  // {"key":""zZdDW1bDCVTXXuoL"}
		    
		    //** 네이버가 발급해 준 캡차 키는 JSON 형식이므로 JSONParser 를 이용해서 JSONObject 로 변환한다. **//
		    JSONParser parser = new JSONParser();
		    JSONObject obj = (JSONObject) parser.parse(message);
		    String key = (String) obj.get("key");  // "zZdDW1bDCVTXXuoL
		    
		    //사용자 입력 검증을 위해서 발급 받은 key와 사용자입력을 보내줘야하기때문에
		    //session에 저장해둔다.
		    HttpSession session =request.getSession();
		    session.setAttribute("key", key);		    		    
		    // System.out.println(key);
		    //*************************************************************************************************//
		    
		    
		    /***** 2. 캡차 이미지 발급 요청하기 *****/
		    
		    apiURL = "https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=" + key;
		    
		    url = new URL(apiURL);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
		    conn.setRequestProperty("X-Naver-Client-Id", clientId);
		    conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
		    responseCode = conn.getResponseCode();
		    String filename = null;
		    if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
		    	filename = getImage(request, conn.getInputStream());
		    } else {  // 에러 발생
		    	message = error(conn.getErrorStream());
		    }
		    
		    //** filename 을 request 에 저장하고, request 를 함께 이동시켜서 **//
		    //** loginPage.jsp 에서 확인할 수 있도록 한다. **//
		    request.setAttribute("filename", filename + ".jpg");
		    //request.getRequestDispatcher("loginPage.jsp").forward(request, response);
		    //*****************************************************************//
		    
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "loginPage.jsp";
	}
	
	private static String readBody(InputStream body){
	    InputStreamReader streamReader = new InputStreamReader(body);
	
	    try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	        StringBuilder responseBody = new StringBuilder();
	
	        String line;
	        while ((line = lineReader.readLine()) != null) {
	            responseBody.append(line);
	        }
	
	        return responseBody.toString();
	    } catch (IOException e) {
	        throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	    }
	}

	private static String getImage(HttpServletRequest request, InputStream is) {
        int read;
        byte[] bytes = new byte[1024];
        // 랜덤한 이름으로  파일 생성
        String filename = Long.valueOf(new Date().getTime()).toString();
        
        //** 캡차 이미지가 저장될 storage 디렉토리의 경로를 구한다. **//
        final String DIRECTORY = "storage";
        
        request.setAttribute("DIRECTORY", DIRECTORY);
        
        String realPath = request.getServletContext().getRealPath("/" + DIRECTORY);
        File f = new File(realPath + "/" + filename + ".jpg");
        //************************************************************//
        
        // try-catch-resource : close() 생략 가능
        try (OutputStream outputStream = new FileOutputStream(f)) {
            f.createNewFile();
            while ((read = is.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            return filename;
        } catch (IOException e) {
            throw new RuntimeException("이미지 캡차 파일 생성에 실패 했습니다.",e);
        }
    }

    private static String error(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
	
}