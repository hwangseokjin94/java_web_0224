package com.koreait.ex;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex08_FileWriter {
	public static void main(String[] args) {
		// FileWriter
		// 1.문자기반스트림
		// 2.byte[] 배열 대신 char[],String을 사용한다.
		// 3.나머지특성은 FileOutputStream과 동일하다.
		
		FileWriter fw = null;
		try {
			fw = new FileWriter("text.txt");
			fw.write("안녕하세요. 반갑습니다. ");
			fw.write('\n'); //인트타입은 작은따옴표
			fw.write("Nice to meet you");
			JOptionPane.showMessageDialog(null, "txext.txt 파일이 생성되었다.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fw != null) {
					fw.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		
		
	}
}
