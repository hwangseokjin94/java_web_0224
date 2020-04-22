package com.koreait.ex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex01_FileOutputStream { // 파일출력스트림은 파일을 만드는 스트림.
										// 파일은 일방적인통로 꺼내오지는 못함.
	public static void main(String[] args) {
		// FileOutputStream 객체선언
		// 선언만하는 이유 : 생성 (new)하기 위해서는 반드시 예외 처리가 필요하다.

		FileOutputStream fos = null; // 통로생성
		// 파일에보낸 데이터 저장
		String message = "Hello World";
		String greeting = "Nice to meet you";

		int ch1 = 'A';
		int ch2 = 'Z';

		// FileOutputStream 객체 생성은 try문이 반드시 필요하다.
		try {
			fos = new FileOutputStream("first.txt");
			// int 타입을 파일로 보내기
			fos.write(ch1);
			fos.write(ch2);
			fos.write('\n');

			// String 타입을 파일로 보내기
			// String ->byte[] : getBytes()메소드
			fos.write(message.getBytes());
			fos.write('\n');
			fos.write(greeting.getBytes());

			// 완료메시지
			JOptionPane.showMessageDialog(null, "first.txt 파일이 생성되었다.");
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "first.txt 파일이 생성되지않았다.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "first.txt 파일에 데이터를 기록하지 못했다.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "알 수 없는 예외가 발생하였다.");
		} finally {
			// FileOutputStream 객체를 닺을때에도
			// 반드시 예외처리를 해야한다.!!!!!!!!!!!!!!!!!!!!
			// close()메소드를 try내부에 두라는 의미

			try {
				if(fos !=null) {
				fos.close();
				}
			} catch (Exception e) {
				
			}

		}

	}
}
