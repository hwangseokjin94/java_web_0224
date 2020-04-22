package com.koreait.ex;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex05_BufferedInputStream {

	public static void main(String[] args) {
		BufferedInputStream bis = null;

		StringBuffer readBuffer = new StringBuffer();
		int state = 0;
		try {
			bis = new BufferedInputStream(new FileInputStream("second.txt"));
			while (true) {
				byte[] byteArray = new byte[12];
				state = bis.read(byteArray);
				if (state == -1) {
					break;
				}
				readBuffer.append(new String(byteArray));
			} // while
			JOptionPane.showMessageDialog(null, readBuffer);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis!=null) {
					bis.close();
				}
			}catch (Exception e) {
				
			}
		}//try

	}//main

}
