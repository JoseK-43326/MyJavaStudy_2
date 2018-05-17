package com.JoseK.project;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ChatServer {
	
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	private JTextArea text;
	private Socket client;
	private static int countClient = 0;
	private ArrayList<SendThread> clients = new ArrayList<SendThread>();
	
	
	public static void main(String[] args) {
		
		new ChatServer().ClientConnect();
	}
	
	public void launchFrame(){
		JFrame frame = new JFrame();
		frame.setTitle("ChatClient");
		frame.setSize(WIDTH,HEIGHT);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\qq.png"));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		text = new JTextArea(20,200);
		text.setLineWrap(true);
		text.setEditable(false);
		JScrollPane scroll = new JScrollPane(text);
		frame.add(scroll);
		frame.setVisible(true);
		
	}
	
	public void ClientConnect(){
		launchFrame();
		try {
			ServerSocket server = new ServerSocket(8888);
			while(true){
				client = server.accept();
				SendThread send = new SendThread(client);
				clients.add(send);
				countClient++;
				text.append("客户端"+countClient+"已连接\n");				
				new Thread(send).start();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class SendThread implements Runnable{
		private DataInputStream dis;
		private DataOutputStream dos;
		private boolean isRunning = true;
		private int index;
		public SendThread(Socket client) {
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public void send(String str){
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}						
		}
		
		public void run() {
			index = clients.indexOf(this);
			while(isRunning){
			try {
				String msg = dis.readUTF();
				for(int i = 0; i < clients.size(); i++){
					SendThread c = clients.get(i);
					c.send("Client " + index + ": " + msg);
				}
			} catch (IOException e) {
				text.append("客户端"+ countClient+"已退出连接"+"\n");
				countClient--;
				isRunning = false;
			}
			}
		}
		
	}
}



