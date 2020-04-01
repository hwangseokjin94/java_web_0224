package com.koreait.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
//FileInputStream : 파일의 내용을 읽음
//FileOutputStream : 파일의 내용을 작성함


public class Ex02_FIleInputStream {// 파일빼오기작업
	public static void main(String[] args) {
		// FileInputStream 객체의 선언

		FileInputStream fis = null;

		// 읽어 들인데이터를 저장할 변수 및 배열 선언
		StringBuffer readBuffer = new StringBuffer();// byteArray의 데이터를 계속해서 읽어들여 누적할 변수
		int state = 0; // 더 읽을 데이터가 남아있는지 상태확인

		// FileInputStream 객체 생성은 try내부에서해야한다.
		try {
			// first.txt ->byteArray(10 바이트)
			fis = new FileInputStream("first.txt");
			while (true) {
				byte[] byteArray = new byte[10]; // 10바이트
				state = fis.read(byteArray);
				if (state == -1) {
					// read()메소드가 -1을 리턴하면 파일이 종료되었다는 의미이다.
					break;
				}
				// byteArray -> readBuffer
				//readBuffer.append(byteArray);// byte[]->StringBuffer  ※실행결과 안된다.
				readBuffer.append(new String(byteArray));//byte[] ->String ->StringBuffer   String에서 바이트배열을 받는게있어서 처리한다.

			} // while

			JOptionPane.showMessageDialog(null, readBuffer);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fis 의 close() 호출은 예외 처리가 반드시 필요하다.
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {

			}
		}//finally

	}
}
