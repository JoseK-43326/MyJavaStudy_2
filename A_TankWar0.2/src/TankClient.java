import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class TankClient extends JFrame{
	
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	Tank MyTank = new Tank(50,50,this);
	ArrayList<Missile> missiles = new ArrayList<Missile>();
	
	public static void main(String[] args) {
		new TankClient().launchFrame();
	}
	
	public void launchFrame(){
		
		setTitle("TankWar");
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\java\\Image\\Tank.png"));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		setResizable(false);
		TankPanel panel = new TankPanel();
		add(panel);
		addKeyListener(new KeyMonitor());
		setVisible(true);
		new Thread(new MoveThread()).start();
	}
	
	private class TankPanel extends JPanel{
		
		public TankPanel(){
			setBackground(Color.GREEN);
		}		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for(int i = 0; i < missiles.size(); i++){
				missiles.get(i).draw(g);
			}				
			MyTank.draw(g);
			g.drawString("Missiles count: " + missiles.size(), 10, 60);
		}		
	}
	
	private class KeyMonitor extends KeyAdapter{

		public void keyReleased(KeyEvent event) {
			MyTank.isKeyUp(event);
		}
		public void keyPressed(KeyEvent event) { 
			MyTank.KeyPressed(event);
		}		
	} 
	
	private class MoveThread implements Runnable {
		
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}
	
}
