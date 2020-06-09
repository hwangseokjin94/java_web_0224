package ex_json;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Ex02_JSONArray {

	public static void main(String[] args) {
     
     //JSON배열
     
     //   예시
     //  [{"name":"emily","age":20,"isAdult":true},{"name":"james","age":21,"isAdult":true}]
     
		String strJSON ="[{\"name\":\"emily\",\"age\":20,\"isAdult\":true},{\"name\":\"james\",\"age\":21,\"isAdult\":true}]";
		
		JSONParser parser = new JSONParser();
		JSONArray list = null ;
		try {
			list = (JSONArray)parser.parse(strJSON);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	//JSONArray는 자바의  List인터페이스를 구현하기 때문에
	//ArrayList 와 사용법이같다.
		
		System.out.println(list.get(0)); // 저장된 첫번쨰 JSONObject
		
		System.out.println(list.get(1));// 저장된 두번쨰 JSONObject
		
		
	}

}
