package com.koreait.test;

import java.io.File;

public class Test05 {
public static void main(String[] args) {
	
	File dir = new File("C:"+File.separator+"Dir");
	if(dir.exists()) {
		if(dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(int i = 0 ;i <files.length; i++) {
				files[i].delete();
				System.out.println(files[i].getName()+"삭제완료");
			}
		}
	}
	
	if(dir.delete()) {
		System.out.println(dir.getName()+"디렉토리 삭제완료");
	}
	
	
}
}
