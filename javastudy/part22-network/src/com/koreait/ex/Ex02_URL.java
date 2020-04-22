package com.koreait.ex;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.xml.crypto.URIReferenceException;

public class Ex02_URL {
	public static void main(String[] args) {
		String host= "http://springlec.cafe24.com/lecture/alphabet.txt?teacher=gtmin";
		
		URL url = null;
		try {
			 url = new URL(host);
			
			System.out.println(url.getAuthority());//springlec.cafe24.com
			System.out.println(url.getContent());//sun.net.www.content.text.PlainTextInputStream@53d8d10a
			System.out.println(url.getDefaultPort());//80
			System.out.println(url.getPort());//-1
			
			System.out.println(url.getPath());// /lecture/alphabet.txt
			System.out.println(url.getFile());// /lecture/alphabet.txt?teacher=gtmin

			System.out.println(url.getProtocol());//http
			System.out.println(url.getHost());//springlec.cafe24.com
			
			System.out.println(url.toURI());//http://springlec.cafe24.com/lecture/alphabet.txt?teacher=gtmin

			
			
			
			
		}catch (MalformedURLException e) {
			System.out.println("없는 HOST 이다");
		}catch (IOException e) {
			System.out.println("연결불가");
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
