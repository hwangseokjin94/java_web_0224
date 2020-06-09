package ex_json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Ex01_JSONObject {
	public static void main(String[] args) {
		//JSON :JavaScript Object Notation
		//1.자바스크립트의 객체 표기법이다.
		//2.{"키":값,"키":값,...}
		//3.단일 JSON데이터는 자바의 Map에대은된다 .
		//예제 JSON 

		//{"name":"emily","age":20,"isAdult":true}
		
		String strJSON = "{\"name\":\"emily\",\"age\":20,\"isAdult\":true}";
		
		//json-simple-1.1.1.jar
		//JSON데이터 -> MAP과 같은 형태의 JSONObject
		
		//1. JSON 파서(parser) : 구문분석기
		JSONParser parser = new JSONParser();
		
		//2JSONObject  : JSON객체
		JSONObject obj = null;
		
		//3.파싱 :구문분석
		//parser 가 strJSON 을 obj로 변환시켜준다.
		try {
			
			obj = (JSONObject)parser.parse(strJSON);
		}catch (Exception e) { //ParseException
			e.printStackTrace();
		}
		
		//4.JSONObject클래스는 Map인터페이스를 구현한 구현클래스이므로,
		// HashMap과 사용법이 같다 . . .
		System.out.println("이름 :"+obj.get("name") );
		System.out.println("나이 :"+obj.get("age") );
		System.out.println((boolean)obj.get("isAdult") ? "성인" : "미성년자" );
		
		
	}
}
