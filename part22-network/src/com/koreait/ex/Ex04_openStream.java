package com.koreait.ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex04_openStream {
	public static void main(String[] args) {
		String host = "https://m.naver.com";
		URL url = null;
		BufferedReader br = null;
		StringBuffer readBuffer = new StringBuffer();
		String lineContent = "";
		try {
			url = new URL(host);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			while ( (lineContent=br.readLine())  !=null ) {
				readBuffer.append(lineContent);
			}
			System.out.println(readBuffer);
		} catch (IOException e) {
			// TODO: handle exception
		}
	}
}
