package com.koreait.ex;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex10_BufferedWrite {
	public static void main(String[] args) {
	
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("sample.txt"));
	
			bw.write("BufferedWriter 클래스를 활용해 만든 파일이다. \n");
			bw.write("FileWriter 클래스에 비해 속도가 빠르다.");
			
			JOptionPane.showMessageDialog(null, "sample.txt파일이 생성되었다.");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(bw !=null) {
					bw.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
