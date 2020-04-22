package com.koreait.ex;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ex06_openStream {
	public static void main(String[] args) {
		String host = "http://springlec.cafe24.com/lecture/alphabet.txt";
		
		URL url = null;
		URLConnection conn = null ;
		Scanner sc = new Scanner(System.in);
		BufferedOutputStream bos = null;
		try {
			url= new URL(host);
			conn = url.openConnection();
			sc = new Scanner(new BufferedInputStream(conn.getInputStream()));
			bos = new BufferedOutputStream(new FileOutputStream("alphabet2.txt"));
			while(sc.hasNext()) {
				String lineContent= sc.nextLine();
				bos.write(lineContent.getBytes());
				bos.write('\n');
			}
			JOptionPane.showMessageDialog(null, "alphabet2.txt");
		} catch (MalformedURLException e) {
				e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bos !=null) {
					bos.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
