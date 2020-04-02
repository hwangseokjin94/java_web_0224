package com.koreait.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class Ex05_openStream {
	public static void main(String[] args) {
		String host = "http://springlec.cafe24.com/lecture/alphabet.txt";
		URL url = null;
		BufferedInputStream bis = null;// host읽어들이기
		BufferedOutputStream bos = null;// 새로만들 alphabet.txt생성용

		int ch = 0;
		try {
			url = new URL(host);
			bis = new BufferedInputStream(url.openStream()); // src
			bos = new BufferedOutputStream(new FileOutputStream("alphabet.txt"));// copy

			while ((ch = bis.read()) != -1) {
				bos.write(ch);
			}
			JOptionPane.showMessageDialog(null, "alphabet.txt파일이다운로드되었다.");
		} catch (MalformedURLException e) {
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
					bis.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
