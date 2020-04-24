package com.koreait.ex;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex13_Serializable {
public static void main(String[] args) {
	
	ObjectInputStream ois = null;
	
	try {
		ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("user.ser")));
		//user.ser파일에 저장된 객체순서 : user1 ->user2->list
		
		User user1 = (User)ois.readObject();
		User user2 = (User)ois.readObject();
		ArrayList<User> list= (ArrayList<User>)ois.readObject();
		//toString() 메소드가 오버라이드 되어 객체 자체로 출력이가능다.
		System.out.println("회원1: "+user1);
		System.out.println("회원2: "+user2);
		System.out.println("회원들: "+list);
		
		
		
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch (FileNotFoundException e) {
		e.printStackTrace();
	}catch (IOException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(ois != null) {ois.close();}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
}
