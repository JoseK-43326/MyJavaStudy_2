import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;


public class Tank {

	private int locate_x,locate_y;
	private final int X_Speed = 5;
	private final int Y_Speed = 5;	
	private final int WIDTH = 30;
	private final int HEIGHT = 30;
	private boolean up_key = false;
	private boolean right_key = false;
	private boolean down_key = false;
	private boolean left_key = false;	
	enum Direction{UP,RIGHT_UP,RIGHT,RIGHT_DOWN,DOWN,LEFT_DOWN,LEFT,LEFT_UP,STOP}
	private Direction dir = Direction.STOP;
	private Direction ptDir = Direction.DOWN;
	TankClient tc;
	
	public Tank(int x, int y){
		locate_x = x;
		locate_y = y;
	}
	public Tank(int x, int y, TankClient tc){
		this(x,y);
		this.tc = tc;
	}
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double tank = new Ellipse2D.Double(locate_x,locate_y,WIDTH,HEIGHT);
		g2.setPaint(Color.RED);
		g2.fill(tank);		
		switch(ptDir){
		case UP:
			g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x+WIDTH/2, locate_y);
			break;
		case RIGHT_UP:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x+WIDTH, locate_y);
			break;
		case RIGHT:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x+WIDTH, locate_y+HEIGHT/2);
			break;
		case RIGHT_DOWN:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x+WIDTH, locate_y+HEIGHT);
			break;
		case DOWN:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x+WIDTH/2, locate_y+HEIGHT);
			break;
		case LEFT_DOWN:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x, locate_y+HEIGHT);
			break;
		case LEFT:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x, locate_y+HEIGHT/2);
			break;
		case LEFT_UP:g2.setPaint(Color.BLACK);
			g2.drawLine(locate_x+WIDTH/2, locate_y+HEIGHT/2, locate_x, locate_y);
			break;
		}
		move();	
	}
		
	public void isKeyUp(KeyEvent event){
		int key = event.getKeyCode();
		switch (key) {
		case KeyEvent.VK_CONTROL:
			tc.missiles.add(fire());
			break;
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
			dir = Direction.UP;
		else if(up_key && right_key && !down_key && !left_key)
			dir = Direction.RIGHT_UP;
		else if(!up_key && right_key && !down_key && !left_key)
			dir = Direction.RIGHT;
		else if(!up_key && right_key && down_key && !left_key)
			dir = Direction.RIGHT_DOWN;
		else if (!up_key && !right_key && down_key && !left_key)
			dir = Direction.DOWN;
		else if(!up_key && !right_key && down_key && left_key)
			dir = Direction.LEFT_DOWN;
		else if(!up_key && !right_key && !down_key && left_key)
			dir = Direction.LEFT;
		else if(up_key && !right_key && !down_key && left_key)
			dir = Direction.LEFT_UP;
		else if(!up_key && !right_key && !down_key && !left_key)
			dir = Direction.STOP;
		if(this.dir != Direction.STOP)
			this.ptDir = this.dir;		
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
	
	public Missile fire(){
		Missile missile = new Missile(locate_x + WIDTH/2 - Missile.WIDTH/2,locate_y + HEIGHT/2 - Missile.HEIGHT/2 ,ptDir,tc);	
		return missile;
	}
	
	
}
