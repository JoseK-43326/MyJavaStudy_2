package com.JoseK.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


public class Server {

	public static void main(String[] args) throws IOException {
		
		DatagramSocket server = new DatagramSocket(5555);
		byte[] container = new byte[1024];
		DatagramPacket packet = new DatagramPacket(container, container.length);
		server.receive(packet);
		//处理数据
		double data = convet(packet.getData());
		System.out.println(data);
		server.close();
	}

	private static double convet(byte[] d) throws IOException {
		
		double data = 0;
		ByteArrayInputStream bis = new ByteArrayInputStream(d);
		DataInputStream dis = new DataInputStream(bis);
		data =  dis.readDouble();
		return data;
	}

}
