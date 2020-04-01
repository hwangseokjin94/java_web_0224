package com.koreait.test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
Test01.java

다음 내용을 저장하는 alphabet.txt 파일을 생성하시오.
BufferedOutputStream 클래스를 이용하시오.

<< alphabet.txt >>
ABCDEFGHIJKLMNOPQRSTUVWXYZ
abcdefghijklmnopqrstuvwxy
*/
public class Test01 {

	public static void main(String[] args) {

		BufferedOutputStream bos = null;
//		FileOutputStream fos = null;

		try {
//			fos = new FileOutputStream("alphabet.txt");
			bos = new BufferedOutputStream(new FileOutputStream("alphabet.txt"));
			int ch = 'A'; // '\0' 널문자 \0 ....A.....Z......a.....z......
			while (ch <= 'z') { 
				if (ch >= 'A' && ch <= 'Z') {// 대문자만 alphabet.txt로 보내는코드
					bos.write(ch);

				} else if (ch >= 'a' && ch <= 'z') {// 소문자만 alphabet.txt로 보내는코드
					bos.write(ch);
				}
				if (ch == 'Z') {// 대문자 출력이끝난상황으로 줄바꿈이 필요하다.
					bos.write('\n');
				}
				ch++; // 다음 문자로이동
			} // while문 종료

			JOptionPane.showMessageDialog(null, "alphabe.txt 파일이 생성되었다.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (bos != null) {
					bos.close();
				}
			} catch (Exception e) {

			}

		}

	}// main

}
