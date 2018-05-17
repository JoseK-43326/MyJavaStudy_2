import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class TankClient {

	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

}

class MyFrame extends JFrame{
	
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	Tank tank1 = new Tank(20, 20);
	public MyFrame(){
		
		setTitle("TankWar");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\Tank.png"));
		setResizable(false);
		MyPanel panel = new MyPanel(); 
		add(panel,BorderLayout.CENTER);
		addKeyListener(new KeyControl());
		
	}
	class KeyControl implements KeyListener{

		public void keyPressed(KeyEvent event) {
			tank1.keyPressed(event);							
		}
		public void keyReleased(KeyEvent event) {
			tank1.isKeyUp(event);	
		}
		public void keyTyped(KeyEvent event) {
			
		}		
	}
	class MyPanel extends JPanel{
		public MyPanel(){
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			setBackground(Color.GREEN);	
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);			
			tank1.paintTank(g);
			repaint();
		}	
	}
	
}
 

