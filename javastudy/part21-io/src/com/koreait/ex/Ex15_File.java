package com.koreait.ex;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Ex15_File {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("찾는 파일이나 디렉토리 이름 입력");
		String find = sc.nextLine();

		File dir = new File("C:" + File.separator + "Dir");
		if (dir.exists()) {
//			System.out.println(dir.getName() + " 디렉토리가있다");
			if (dir.isDirectory()) {
//				System.out.println(dir.getName() + "는 디렉토리이다.");
				File[] files = dir.listFiles();
//				System.out.println(Arrays.deepToString(files));
				for (int i = 0; i < files.length; i++) {
					if (find.equalsIgnoreCase(files[i].getName())) {
//						System.out.println(find + "가있다.");
						files[i].delete(); //내용물이 있는 디렉토리는 삭제되지않는다.
						System.out.println(files[i]+"가 삭제되엇다");
					}
				}
			}
		}
	}//main
}
