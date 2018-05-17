package com.JoseK.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddres {

	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		addr = InetAddress.getByName("www.baidu.com");
		System.out.println(addr.getHostAddress());
		System.out.println(addr.getHostName());
		
		addr = InetAddress.getByName("127.0.0.1");
		System.out.println(addr.getHostName());

	}

}
