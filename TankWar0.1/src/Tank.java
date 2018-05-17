import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;

public class Tank {
	private static final int X_SPEED = 5;
	private static final int Y_SPEED = 5;
	private int x_location,y_location; 
	
	public Tank(int x, int y){
		this.x_location = x;
		this.y_location = y;
	}
	public void paintTank(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D tank = new Ellipse2D.Double(x_location, y_location, 30, 30);
		g2.setPaint(Color.RED);
		g2.fill(tank);	
	}
	public void keyPressed(KeyEvent event){
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
}
