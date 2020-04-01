package com.koreait.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
Test03.java
alphabet.txt 파일을 복사하시오
복사된 파일의 이름은alphabet.txt파일로지정하시오
파일 복사에 걸린시간을 결과로 출력하시오
*/
public class Test03_1 {
	public static void main(String[] args) {
		BufferedInputStream bis = null; // alphabet읽어들이기
		BufferedOutputStream bos = null;// alphabet2.txt만들기

		try {
			bis = new BufferedInputStream(new FileInputStream("alphabet.txt"));// 읽을거
			bos = new BufferedOutputStream(new FileOutputStream("alphabet2.txt"));// 만들거
			long start = System.nanoTime();

			//2.byte[]단위로 복사하기
			byte[]byteArray = new byte[1024];//1024바이트1KB
			while(bis.read(byteArray)!= -1) {
				bos.write(byteArray);
			}
			
			
			
			long end = System.nanoTime();

			System.out.println("복사시간 : " + (end - start) / Math.pow(10, 9) + "초");

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
				if (bis != null) {
					bos.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}//픽사베이 영상다운해서 테스트해보기
