import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class ChatClient extends JFrame{
	
	private JTextArea textArea;
	private JTextField textField;
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}
	
	public void launchFrame(){
		setTitle("Chat");
		setSize(400,300);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\Image\\qq.png"));
		setLocation(200, 200);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				disconnect();
				System.exit(0);
			}
		});
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		textField = new JTextField();
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
System.out.println("connect");
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void disconnect(){
		try {
			dos.close();
			dis.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private class TextListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			String str = textField.getText().trim();
			if(str.length() > 0){
System.out.println(str);
			//textArea.append(str + '\n');
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			textField.setText("");
		}		
	}
	
	private class ReceiveThread implements Runnable{
		private boolean isConnect = false; 
		public void run() {
			isConnect = true;
			while(isConnect){
			try {
				String str = dis.readUTF();
				textArea.append(str + '\n');
			} catch(SocketException e){
				System.out.println("当前客户端与服务器断开连接！");
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
		}		
	}

}
