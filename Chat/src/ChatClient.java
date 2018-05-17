import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;


public class ChatClient extends JFrame{
	
	private JTextField textField;
	private JTextArea textArea;
	private JScrollPane scroll;
	private Socket socket;
	private DataOutputStream dos = null;
	private DataInputStream dis = null;
	private boolean isConnected = false;
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}
	
	public void launchFrame(){
		setTitle("ChatClient");
		setSize(400, 400);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event){
				disConnect();
				System.exit(0);
			}						
		});
		textField = new JTextField();
		textArea = new JTextArea(400,350);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea);
		add(scroll,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		textField.addActionListener(new TextListener());
		setVisible(true);
		connect();
		new Thread(new ReceiveThread()).start();
		
	}
	public void connect(){
		try {
			socket = new Socket("127.0.0.1", 8080);	
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			//System.out.println("connect");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public void disConnect(){
		try {
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	class TextListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			String s = textField.getText().trim();
			//textArea.append(s+ "---->" +new Date()+'\n');	
			textField.setText("");
			try {
				dos.writeUTF(s);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}		
	}
	
	private class ReceiveThread implements Runnable{
		
		public void run() {
			isConnected = true;
			while(isConnected){
				try {					
					String str = dis.readUTF();
					textArea.append(str + '\n');
				}catch (SocketException e) {
					System.out.println("ÍË³ö³ÌÐò");
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}

}
