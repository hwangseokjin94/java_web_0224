package com.koreait.ex;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex06_DataOutputStream {

	public static void main(String[] args) {

		DataOutputStream dos = null;

		int[] score = { 10, 20, 30, 40, 50 };
		try {
			dos = new DataOutputStream(new FileOutputStream("score.bin"));
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);
			}
			JOptionPane.showMessageDialog(null, "score.bin 파일에 점수가 저장되었다.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();

				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
