import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;


public class ChatServer extends JFrame{
	
	private ServerSocket ss;
	private boolean isConnect = false;
	private boolean isWriting = false;
	private JTextArea textArea;
	private static int countClient = 0;
	private ArrayList<Client> clients = new ArrayList<Client>();
	public static void main(String[] args) {
		new ChatServer().startServer();
	}
	
	public void launchFrame(){
		setTitle("ChatServer");
		setSize(300,300);
		setLocation(0, 0);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\Image\\server.png"));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}			
		});
		textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		textArea.setText("服务器已经启动!" + '\n' + '\n');
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		add(scroll, BorderLayout.CENTER);
		setVisible(true);
	}
	public void startServer(){
		launchFrame();
		try {
			ss = new ServerSocket(8080);
			isConnect = true;
			while(isConnect){ 
				Socket s = ss.accept();
System.out.println("a client connected !");
				textArea.append("Client" + "" + countClient + " is connected !" + '\n' + '\n');				
				Client client = new Client(s);
				clients.add(client);
				countClient++;
				new Thread(client).start();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}		
	}
	
	private class Client implements Runnable{
		private Socket s;
		private DataInputStream dis;
		private DataOutputStream dos;
		private int index;
		
		public Client(Socket s){
			this.s = s;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
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
			isWriting = true;
			index = clients.indexOf(this);
			while(isWriting){
			try {
			String str = dis.readUTF();
System.out.println(str); 
			for(int i = 0; i < clients.size(); i++){
				Client c = clients.get(i);
				c.send("Client " + index + ": " + str);
			}
			}catch(EOFException e){				
				try {
					dis.close();
					s.close();
					clients.remove(this);
					countClient--;
					textArea.append("Client " + index + " 退出连接 ！" + '\n' + '\n');
System.out.println("Client " + index + " 退出连接 ！");
					return;
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				}catch (IOException e) {
				e.printStackTrace();
				}
			}
		}		
	}

}
