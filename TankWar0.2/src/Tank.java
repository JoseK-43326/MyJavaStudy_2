import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;


public class Tank {
	private static final int X_SPEED = 5;
	private static final int Y_SPEED = 5;
	private int x_location,y_location; 
	private boolean U_Key = false;
	private boolean D_Key = false;
	private boolean L_Key = false;
	private boolean R_Key = false;
	private Direction dir = null;
	private enum Direction{
		NORTH,NROTH_EAST,EAST,EAST_SOUTH,
		SOUTH,WEST_SOUTH,WEST,WEST_NORTH;
	}
	
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
	
	public void isKeyDown(KeyEvent event){
		int key = event.getKeyCode();
		switch(key){
			case KeyEvent.VK_UP:
				U_Key = true;break;
			case KeyEvent.VK_DOWN:
				D_Key = true;break;
			case KeyEvent.VK_LEFT:
				L_Key = true;break;
			case KeyEvent.VK_RIGHT:
				R_Key = true;break;		
		}
		
	}
	public void isKeyUp(KeyEvent event){
		int key = event.getKeyCode();
		switch(key){
			case KeyEvent.VK_UP:
				U_Key = false;break;
			case KeyEvent.VK_DOWN:
				D_Key = false;break;
			case KeyEvent.VK_LEFT:
				L_Key = false;break;
			case KeyEvent.VK_RIGHT:
				R_Key = false;break;		
		}		
	}
	public Direction changeDirection(KeyEvent event){
		isKeyDown(event);
		if(U_Key && !D_Key && !L_Key && !R_Key) 
			dir = Direction.NORTH;
		else if (!U_Key && D_Key && !L_Key && !R_Key)
			dir = Direction.SOUTH;
		else if (!U_Key && !D_Key && L_Key && !R_Key)
			dir = Direction.WEST;
		else if (!U_Key && !D_Key && !L_Key && R_Key)
			dir = Direction.EAST;
		else if (U_Key && !D_Key && !L_Key && R_Key)
			dir = Direction.NROTH_EAST;
		else if (U_Key && !D_Key && L_Key && !R_Key)
			dir = Direction.WEST_NORTH;
		else if (!U_Key && D_Key && L_Key && !R_Key)
			dir = Direction.WEST_SOUTH;
		else if (!U_Key && D_Key && !L_Key && R_Key)
			dir = Direction.EAST_SOUTH;
	return dir;
	}
	public void keyPressed(KeyEvent event){
		Direction dir = changeDirection(event);
		switch(dir){
			case NORTH:
				{
					y_location -= Y_SPEED;
					if(y_location <= 0) y_location = 0;
				}
				break;
			case NROTH_EAST:
				{
					x_location += X_SPEED;
					y_location -= Y_SPEED;
					if(x_location >= 770) x_location = 770;
					if(y_location <= 0) y_location = 0;
				}
				break;
			case EAST:
				{
					x_location += X_SPEED;
					if(x_location >= 770) x_location = 770;
				}
				break;
			case EAST_SOUTH:
				{
					y_location += Y_SPEED;
					x_location += X_SPEED;
					if(y_location >= 570) y_location = 570;
					if(x_location >= 770) x_location = 770;
				}
				break;
			case SOUTH:
			{
				y_location += Y_SPEED;
				if(y_location >= 570) y_location = 570;
			}
			break;
			case WEST_SOUTH:
			{
				y_location += Y_SPEED;
				x_location -= X_SPEED;
				if(y_location >= 570) y_location = 570;
				if(x_location <= 0) x_location = 0;
			}
			break;
			case WEST:
			{
				x_location -= X_SPEED;
				if(x_location <= 0) x_location = 0;
			}
			break;
			case WEST_NORTH:
			{
				y_location -= Y_SPEED;
				x_location -= X_SPEED;
				if(y_location <= 0) y_location = 0;
				if(x_location <= 0) x_location = 0;
			}
			break;
		   }
		}
}
