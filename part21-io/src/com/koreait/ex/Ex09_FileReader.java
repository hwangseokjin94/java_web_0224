package com.koreait.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex09_FileReader {
	public static void main(String[] args) {
		// FileReader
		// 1. 문자기반 스트림이다.

		// FileInputStream과 FileReader비교

		FileInputStream fis = null;
		FileReader fr = null;

		try {
			// FileInputStream
			int ch1 = 0;
			fis = new FileInputStream("text.txt");
			while ((ch1 = fis.read()) != -1) {// 한글자씩읽어들이기 read는 더이상 읽어드릴게없으면 -1을 리턴을한다.
				System.out.print((char) ch1);
			}
			System.out.println("\n--------------------------");

			// FileReader
			int ch2 = 0;
			fr = new FileReader("text.txt");
			while ((ch2 = fr.read()) != -1) {
				System.out.print((char) ch2);
			}

		} // try
		catch (FileNotFoundException e) {
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
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
