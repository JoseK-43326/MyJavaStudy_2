package com.JoseK.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class Client {

	
	public static void main(String[] args) throws IOException {
		
		DatagramSocket client = new DatagramSocket(4444);
		double data = 89.12;
		byte[] msg = covert(data);
		DatagramPacket packet = new DatagramPacket(msg, msg.length, new InetSocketAddress("localhost",5555));
		client.send(packet);
		client.close();
	}

	private static byte[] covert(double d) throws IOException {
		
		byte[] msg = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		dos.writeDouble(d);
		dos.flush();
		msg = bos.toByteArray();
		dos.close();
		return msg;
	}
	
}
