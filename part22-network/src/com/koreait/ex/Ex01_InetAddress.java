package com.koreait.ex;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Ex01_InetAddress {
	public static void main(String[] args) {
		//원격호스트확인
		InetAddress ipAddress = null;
		
		String host = "www.naver.com";

		try {
			ipAddress = InetAddress.getByName(host);

			System.out.println(ipAddress);// www.google.com/172.217.26.132
			System.out.println(ipAddress.getHostName());// www.google.com
			System.out.println(ipAddress.getHostAddress());// 172.217.26.132

			byte[] byteIp = ipAddress.getAddress();
			System.out.println(Arrays.toString(byteIp));// [-84, -39, 26, -124] +256을해야 Ip가 됩니다.0보다작은애들만
			String realIp = "";
			for (int i = 0; i < byteIp.length; i++) {
				realIp += (byteIp[i] < 0 ? byteIp[i] + 256 : byteIp[i]);
				if(i<byteIp.length-1) {
				realIp += ".";
				}
			}
			System.out.println(realIp);
		} catch (UnknownHostException e) {
			System.out.println("없는 HOST이다.");
		}

		

		//2.원격Host확인
		InetAddress[] ipList = null;
		try {
			ipList = InetAddress.getAllByName(host);
			for (int i = 0; i < ipList.length; i++) {
				System.out.println((i+1)+"번째 ip"+ipList[i].getHostAddress());
				//1번째 ip210.89.164.90
				//2번째 ip210.89.160.88
			}
		} catch (UnknownHostException e) {
			System.out.println("없는 HOST이다.");
		}
		
		
		//3.로컬 HOST확인
		try {
			ipAddress = InetAddress.getLocalHost();
			System.out.println(ipAddress.getHostName());//DESKTOP-5LOKNF2
			System.out.println(ipAddress.getHostAddress());	//192.168.5.22
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
