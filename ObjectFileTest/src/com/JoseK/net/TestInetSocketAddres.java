package com.JoseK.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author JoseK
 */
public class TestInetSocketAddres {

	public static void main(String[] args) {
		
		InetSocketAddress addres = new InetSocketAddress("localhost", 8888);
		
		System.out.println(addres.getHostName());
		System.out.println(addres.getPort());
		
		InetAddress addr = addres.getAddress();
		System.out.println(addr.getHostName());
		System.out.println(addr.getHostAddress());
		
	}

}
