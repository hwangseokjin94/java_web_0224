package com.koreait.ex;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex03_URLConnection {
	public static void main(String[] args) {
		String host  = "http://springlec.cafe24.com/lecture/alphabet.txt";
		URL url = null;
		URLConnection conn= null;
		try {
			url = new URL(host);
			conn = url.openConnection();
			
			System.out.println(conn.getContentEncoding());//인코딩 방식//null
			System.out.println(conn.getContentType());//text/plain
			System.out.println(conn.getLastModified());//마지막수정일//1585726258000
			System.out.println(conn.getURL());//http://springlec.cafe24.com/lecture/alphabet.txt

			
		} catch (MalformedURLException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} 
		
	}
}
