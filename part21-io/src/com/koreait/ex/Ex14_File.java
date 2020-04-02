package com.koreait.ex;

import java.io.File;
import java.io.IOException;

public class Ex14_File {
	public static void main(String[] args) {
		// File 클래스
		// 파일관련 메소드 : getName(),getPath(),exist()등
		File file = null;

		// 1. myFile.txt 를 파일관련 메소드를 사용하기 위해 file객체 생성(myFile.txt은 아직없다.)
		file = new File("C:\\DATA\\JAVAWEB_0224\\javastudy\\workspace\\part21-io", "myFile.txt");//역슬래쉬 오류를 해결을하려면 File.separator을이용한다.
//		file = new File("D:" + File.separator + "JAVAWEB_0224" + File.separator + "javastudy" + File.separator + "workspace" + File.separator + "part21-io", "myFile.txt");
		
		// 2. myFile.txt 생성(예외 처리가 필요하다.)
		try {
			file.createNewFile(); //fileOutputStream과 같은 출력스트림으로도 가능하다.
//			FileOutputStream fos = new FileOutputStream(file);
			System.out.println("myFile.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("전체 파일명 : " + file.getName());
		System.out.println("경로1 : " + file.getPath());
		System.out.println("경로2 : " + file.getAbsolutePath());
		System.out.println("파일이 저장된 디렉토리(폴더)"  + file.getParent());
		System.out.println("존재유무: "+file.exists());
		System.out.println("삭제 :"+file.delete());
		
		
		
		
		
		
		

	}
}
