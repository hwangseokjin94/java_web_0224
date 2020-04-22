package com.koreait.ex;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex07_DataInputStream {
	public static void main(String[] args) {
		DataInputStream dis = null;
		int score = 0;
		int total = 0;

		try {
			dis = new DataInputStream(new FileInputStream("score.bin"));
			// readInt()메소드
			// 1.정상
			// 2.파일의 종료 : EOFException 발생
			while (true) {
				score = dis.readInt();
				total += score;
				System.out.print(score + " ");
				
			}
			
			
			
		}catch (EOFException e) {
			System.out.println("점수 합 :" + total +"점");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (dis != null) {
					dis.close();

				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

}
