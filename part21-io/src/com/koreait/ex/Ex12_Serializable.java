package com.koreait.ex;//객체정보를 파일로만들어서 파일로 보내겠다.
//직렬화 : java.io.Serializable
//1. 객체를 스트림을 이용해 입출력하고자 하는경우 해당객체를 직렬화한다.
//2. Serializable 인터페이스를 구현하는 구현 클래스로 작성하면 된다.

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

//User
class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4571539742431057026L;
	private String userId;
	private String userPw;
	private int userPoint;

	public User(String userId, String userPw) {
		this(userId, userPw, 1000);//this는 나의 다른생성자를 의미한다 생성자내부에서만쓸수있다.
	}

	public User(String userId, String userPw, int userPoint) {
		this.userId = userId;
		this.userPw = userPw;
		this.userPoint = userPoint;
	}
	//Method
	@Override
	public String toString() {
		return userId+"("+userPoint+"점)";
	}

}

public class Ex12_Serializable {
	public static void main(String[] args) {

		//User 객체 정보를 가진 user.ser파일생성
		
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			bos = new BufferedOutputStream(new FileOutputStream("user.ser"));
			oos = new ObjectOutputStream(bos);
			
			//User 객체 생성
			User user1 = new User("admin","1234");
			User user2 = new User("nimda","4321");
			
			//User 객체의 직렬화 처리
			oos.writeObject(user1);
			oos.writeObject(user2);
			
			//User객체 함번에 보내기
			//ArrayList이용
			List<User> list =new ArrayList<User>();
			list.add(user1);
			list.add(user2);
			oos.writeObject(list);
			
			JOptionPane.showMessageDialog(null, "user.ser파일이 생성되었다.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(oos !=null) {oos.close();}
			} catch (Exception e2) {
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
