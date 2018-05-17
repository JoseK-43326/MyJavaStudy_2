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
	
	private static final int X_SPEED = 5;
	private static final int Y_SPEED = 5;
	private int x_location,y_location; 
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
			int key = event.getKeyCode();
			switch(key){
				case KeyEvent.VK_LEFT:
					{
						x_location -= X_SPEED;
						if(x_location <= 0) x_location = 0;
					}
					break;
				case KeyEvent.VK_RIGHT:
					{
						x_location += X_SPEED;
						if(x_location >= 770) x_location = 770;
					}
					break;
				case KeyEvent.VK_UP:
					{
						y_location -= Y_SPEED;
						if(y_location <= 0) y_location =0;
					}
					break;
				case KeyEvent.VK_DOWN:
					{
						y_location += Y_SPEED;
						if(y_location >= 570) y_location = 570;
					}
					break;			
			}				
		}
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub	
		}
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub	
		}		
	}
	class MyPanel extends JPanel{
		public MyPanel(){
			setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			setBackground(Color.GREEN);	
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			Ellipse2D tank = new Ellipse2D.Double(x_location, y_location, 30, 30);
			g2.setPaint(Color.RED);
			g2.fill(tank);
			repaint();
		}	
	}
	
}
 

