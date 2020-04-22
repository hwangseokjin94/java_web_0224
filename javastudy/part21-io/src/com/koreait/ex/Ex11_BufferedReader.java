package com.koreait.ex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex11_BufferedReader {
	public static void main(String[] args) {

		BufferedReader br = null;
		int state = 0;
		try {
			
			br = new BufferedReader(new FileReader("sample.txt"));
			
			while (true) {
				char[] array = new char[10];
					state =br.read(array);
					if(state == -1) {
						break;
					}
					System.out.print(array);
			}

			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
