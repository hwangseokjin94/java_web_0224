package ex_json;

import org.json.simple.JSONObject;

public class Ex03_toJSONString {
	public static void main(String[] args) {
	
		JSONObject obj = new JSONObject();
		obj.put("name", "david");
		obj.put("age", 15);
		obj.put("isAdult", false);
		
		String strJSON = obj.toJSONString();
		System.out.println(strJSON);
		
	}
}
