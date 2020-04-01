package com.koreait.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

/*Test02.java
alphabet.txt 파일을 읽어 String message 에 저장하시오.
BufferedInputStream 클래스를 이용하시오.
*/
public class Test02 {

	public static void main(String[] args) {
		BufferedInputStream bis = null;

//		int state = 0;
		try {
			bis = new BufferedInputStream(new FileInputStream("alphabet.txt"));
			int ch = 0;
			String message = "";
			while ((ch = bis.read()) != -1) {// bis.read()메소드는 int 단위로 읽어들인다. 따라서 한글자씩읽어드린다.
				// read() 괄호안에 빈거면 4바이트들어오는거
				message += (char)ch;

			} // while
			JOptionPane.showMessageDialog(null, message);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
			} catch (Exception e) {

			}
		} // try

	}// main

}
