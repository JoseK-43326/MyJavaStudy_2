import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class ChatServer {
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	private ServerSocket ss;
	public static void main(String[] args) {
		new ChatServer().start();
	}
	
	public void start(){
		boolean isConnect = false;
		try {
			ss = new ServerSocket(8080);
			isConnect = true;
		}catch (BindException e){
			System.out.println("端口使用中...");
			System.out.println("请关掉相关程序并重启服务器");
			System.exit(0);
		}catch (IOException e) {
			e.printStackTrace();
		}
		try{
		while(isConnect){				
				Socket s = ss.accept();
System.out.println("a client connected!");
				Client c = new Client(s);
				new Thread(c).start();
				clients.add(c);
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
		private boolean isWriting = false;
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
			try{
				while(isWriting){
					String str = dis.readUTF();	
					System.out.println(str);					
					for(int i = 0; i < clients.size(); i++){
						Client c = clients.get(i);
						c.send(str);
					}					
				}
			}catch (EOFException e){
				System.out.println("client disconnected!");
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
					try {
						if(dis != null) dis.close();
						if(dos != null) dos.close();
						if(s != null) s.close();
					} catch (IOException e) {
						e.printStackTrace();
					}				
			}			
		}		
	}
	
}
