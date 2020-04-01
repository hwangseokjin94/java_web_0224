package com.koreait.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Ex03_try_catch_resources {

	
	// try-catch-resources
	// close() 메소드를 자동으로 호출하는 try 문
	/*
	try (스트림 생성) {
		
	} catch () {
		
	}
	*/
	
	
	public static void main(String[] args) {
		
		
		StringBuffer readBuffer = new StringBuffer();
		
		
		// try - catch - resources
		
		try ( FileInputStream fis = new FileInputStream("first.txt") ) {
			
			while (true) {
			
				// first.txt -> int data
				int data = fis.read();
				
				if (data == -1) {
					break;
				}
				
				// int data -> readBuffer
				//readBuffer.append((int)data);
				readBuffer.append((char)data);
				
			}  // while
			
			JOptionPane.showMessageDialog(null, readBuffer);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}  // try

	}  // main

}
