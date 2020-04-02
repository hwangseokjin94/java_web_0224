package com.koreait.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
* 
Test04.java

jquery-3.4.1.js 파일의 공백 문자(스페이스, 탭, 엔터)를 모두 제거하여
크기를 줄인 jquery-3.4.1.min.js 파일을 생성하시오.

*/
public class Test04 {
	public static void main(String[] args) {

		FileReader fr = null;
		FileWriter fw = null;
		try {
			// 파일 읽어들이기
			fr = new FileReader("jquery-3.4.1.js");
			// 파일쓰기
			fw = new FileWriter("jquery-3.4.1.min.js");

			// 공백 문자(' ', '\t','\n)는 fw로 보내지않는다
			int ch = 0;
			while ((ch = fr.read()) != -1) {// 파일이종료될때까지읽어들이기

				if (ch != ' ' && ch != '\t' && ch != '\n' ) {
					fw.write(ch);
				}
			}

			JOptionPane.showMessageDialog(null, "jquery-3.4.1.min.js파일이생성");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
