package command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CheckCaptcha implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/**********3.사용자가 입력한 값 검증하기*********/
	 String clientId = "RysvBcsu80140IlBnAK5";  // 애플리케이션 클라이언트 아이디값";
	 String clientSecret = "YBFmPAzquL";  // 애플리케이션 클라이언트 시크릿값";
	 
	 //사용자가 입력한 값과 발급받은 키 값을 준비
	 request.setCharacterEncoding("utf-8");
	 String input_key =request.getParameter("input_key"); // 사용자가 입력한 캡차 이미지 글자값
	 HttpSession session = request.getSession();
	 String key = (String)session.getAttribute("key"); // 캡차 키 발급시 받은 키값	 
	 String code = "1"; // 키 발급시 0,  캡차 이미지 비교시 1로 세팅      
     String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code + "&key=" + key + "&value=" + input_key; //파리미터값은 바꾸면안됨value는 내비둠
     
     URL  url = new URL(apiURL);
     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
     conn.setRequestMethod("GET");
	 conn.setRequestProperty("X-Naver-Client-Id", clientId);
	 conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
	 
     int responseCode = conn.getResponseCode();
     String strResult = null;
     if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
    	 strResult = readBody(conn.getInputStream());
     } else { // 에러 발생
    	 strResult = readBody(conn.getErrorStream());
     }
	 	//System.out.println(strResult);
	 //{"result":true,"responseTime":6.51}
     //result키값을 가진 데이터가 true이면 입력성공 false이면 입력 실패.
     JSONParser parser = new JSONParser();
     JSONObject obj = (JSONObject)parser.parse(strResult);     
     
     request.setAttribute("result", obj.get("result"));
     
		return "resultPage.jsp";
		
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
	
	
	

}
