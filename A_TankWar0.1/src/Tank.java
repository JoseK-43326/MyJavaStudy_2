import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Tank {

	private int locate_x,locate_y;
	private final int X_Speed = 5;
	private final int Y_Speed = 5;	
	private boolean up_key = false;
	private boolean right_key = false;
	private boolean down_key = false;
	private boolean left_key = false;	
	enum Deriction{UP,RIGHT_UP,RIGHT,RIGHT_DOWN,DOWN,LEFT_DOWN,LEFT,LEFT_UP,STOP}
	private Deriction dir = Deriction.STOP;
	
	public Tank(int x, int y){
		locate_x = x;
		locate_y = y;
	}
	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double tank = new Ellipse2D.Double(locate_x,locate_y,30,30);
		g2.setPaint(Color.RED);
		g2.fill(tank);
		move();		
	}
		
	public void isKeyUp(KeyEvent event){
		int key = event.getKeyCode();
		switch (key) {
		case KeyEvent.VK_UP:up_key = false;
			break;
		case KeyEvent.VK_RIGHT:right_key = false;
			break;
		case KeyEvent.VK_DOWN:down_key = false;
			break;
		case KeyEvent.VK_LEFT:left_key = false;
			break;
		}
		getDeriction();
	}
		
	public void KeyPressed(KeyEvent event){
		int key = event.getKeyCode();
		switch(key){
			case KeyEvent.VK_UP:up_key = true;
				break;
			case KeyEvent.VK_RIGHT:right_key = true;
				break;
			case KeyEvent.VK_DOWN:down_key = true;
				break;
			case KeyEvent.VK_LEFT:left_key = true;
				break;
		}
		getDeriction();
	}
	
	public void getDeriction(){		
		if(up_key && !right_key && !down_key && !left_key)
			dir = Deriction.UP;
		else if(up_key && right_key && !down_key && !left_key)
			dir = Deriction.RIGHT_UP;
		else if(!up_key && right_key && !down_key && !left_key)
			dir = Deriction.RIGHT;
		else if(!up_key && right_key && down_key && !left_key)
			dir = Deriction.RIGHT_DOWN;
		else if (!up_key && !right_key && down_key && !left_key)
			dir = Deriction.DOWN;
		else if(!up_key && !right_key && down_key && left_key)
			dir = Deriction.LEFT_DOWN;
		else if(!up_key && !right_key && !down_key && left_key)
			dir = Deriction.LEFT;
		else if(up_key && !right_key && !down_key && left_key)
			dir = Deriction.LEFT_UP;
		else if(!up_key && !right_key && !down_key && !left_key)
			dir = Deriction.STOP;
		
		
	}	
	public void move(){		
		switch(dir){
		case UP:locate_y -= Y_Speed;
			break;
		case RIGHT_UP:locate_x += X_Speed;locate_y -= Y_Speed;
			break;
		case RIGHT:locate_x += X_Speed;
			break;
		case RIGHT_DOWN:locate_x += X_Speed;locate_y += Y_Speed;
			break;
		case DOWN:locate_y += Y_Speed;
			break;
		case LEFT_DOWN:locate_x -= X_Speed;locate_y += Y_Speed;
			break;
		case LEFT:locate_x -= X_Speed;
			break;
		case LEFT_UP:locate_x -= X_Speed;locate_y -= Y_Speed;
			break;
		case STOP:
			break;
		}
	}
	
	
}
