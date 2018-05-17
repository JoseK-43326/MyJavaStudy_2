import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TankClient extends JFrame{
		
	Tank MyTank = new Tank(50,50);
	public static void main(String[] args) {
		new TankClient().launchFrame();
	}
	
	public void launchFrame(){
		
		setTitle("TankWar");
		setSize(800,600);
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
			MyTank.draw(g);
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
