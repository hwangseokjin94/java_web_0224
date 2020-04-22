package com.koreait.etc;

public class Ex01_String {
	public static void main(String[] args) {
		//1. 문자열 리터럴은 자바에 의해 최적화 가능
		// 같은 문자열 을 또 사용하면 기존 문자열을 사용
		String a = "apple";
		String b = "apple";
		System.out.println(a == b ? "apple 1개": "apple2개");
		System.out.println("a 의 해시코드 (참조값,주소값)="+a.hashCode());
		System.out.println("b 의 해시코드 (참조값,주소값)="+b.hashCode());
		
		//2. new 는 언제나 새로운 문자열을 생성
		String c = new String("Banana");//new
		String d = new String("Banana");
		System.out.println(c==d ? " banana 1개 " : "banana 2개");
		
		//3. equals() , equalsIgnoreCase()
			
		//4. length()
			
		//5. charAt() 

		//6. indexOf() : 지정한 문자의 인덱스를 반환한다.
		String perID = "123456-1234567";
		System.out.println(perID.indexOf('-'));
		System.out.println(perID.indexOf("-"));
		
		//7. lastIndexOf(): 지정한 문자의 마지막 인덱스를 반환.
		String today = "2020.03.26";
		System.out.println(today.lastIndexOf('.'));
		System.out.println(today.lastIndexOf("."));
		
		//8.substring() : 문자열의 일부를 추출
		//1)substring(시작) : 시작포함 ~끝까지 추출
		//2)substring(시작 ,종료 ) : 시작포함~종료 불포함*(종료전까지)추출
		 String phone = "010-1234-5678";
		 String p1 = phone.substring(0,3); // 0 ,1, 2 :시작+추출 할 글자수  = 종료
		 String p2 = phone.substring(4,8);
		 String p3 = phone.substring(9);
		System.out.println(p1+","+p2+","+p3);
		System.out.println(p2);
		System.out.println(p3);
		//문제
		String fullName = "Ex01_String.java";
//		String fileName = ?; //Ex01_String
//		String extName = ?a; //java
		
		 String fileName =     fullName.substring(0, fullName.lastIndexOf('.'));              
		 String extName =   fullName.substring(fullName.lastIndexOf('.') );
		 System.out.println(fileName);
		 System.out.println(extName);
		 
		 //9.replace : 기존 텍스트를 다른 텍스트로 대체
		String str = "hello";
		System.out.println(str.replace("he", "she"));
		 
		 String[] sn = {"123456-1234567","654321-7654321"};
		 
		 /*
		 for(int i = 0 ; i < sn.length ;  i  ++) {
			 
			 sn[i]= sn[i].replace(sn[i].substring(7), "*******");
			 
			 
			 System.out.println(sn[i]);
		 }
	*/
		for(String s :  sn ) {
			System.out.println(s.replace(s.substring(s.indexOf("-")+2), "******"));
		} 
		 
		 
		 
		 
		 
		 
	}
}
