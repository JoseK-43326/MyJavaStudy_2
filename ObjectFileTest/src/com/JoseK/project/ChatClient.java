package com.JoseK.project;


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient {

	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;
	private JTextArea msgText;
	private JTextField sendText;
	private DataOutputStream dos;
	private DataInputStream dis;
	private JButton sendButton;
	private Socket client;
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();	
	}
	
	public void launchFrame(){
		JFrame frame = new JFrame();
		frame.setTitle("ChatClient");
		frame.setSize(WIDTH,HEIGHT);
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\qq.png"));		
		
		JPanel TextPanel = new JPanel();
		TextPanel.setLayout(new GridLayout(2,1));
		sendButton = new JButton("Send");
		msgText = new JTextArea(20,200);
		msgText.setLineWrap(true);
		msgText.setEditable(false);
		JScrollPane scroll = new JScrollPane(msgText);		
		sendText = new JTextField(20);
		sendText.addActionListener(new TextListener());
		JScrollPane scroll1 = new JScrollPane(sendText);	
		TextPanel.add(scroll1);
		TextPanel.add(sendButton);
		frame.add(scroll,BorderLayout.CENTER);
		frame.add(TextPanel,BorderLayout.SOUTH);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setVisible(true);
		connect();
		new Thread(new ReceiveThread()).start();
		
	}
	
	public void connect(){
	
			try {
				client = new Socket("localhost",8888);
				dos = new DataOutputStream(client.getOutputStream());
				dis = new DataInputStream(client.getInputStream());			
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}					
	}
	
	class TextListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			try {
				String msg = sendText.getText();
				sendText.setText("");
				//msgText.append(msg+"\n");
				dos.writeUTF(msg);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	class ReceiveThread implements Runnable{	
		private boolean isRunning = true;
		public void run() {	
			
			while(isRunning){
				try {
					String str = dis.readUTF();
					msgText.append(str+"\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}	
	}

}




