import java.awt.*;
import java.awt.geom.*;

public class Missile {
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	private static final int X_Speed = 10;
	private static final int Y_Speed = 10;
	public int locate_x,locate_y;
	Tank.Direction dir;
	TankClient tc;
	
	public Missile(int locate_x, int locate_y, Tank.Direction dir) {
		
		this.locate_x = locate_x;
		this.locate_y = locate_y;
		this.dir = dir;
	}
	public Missile(int locate_x, int locate_y, Tank.Direction dir, TankClient tc) {
		this(locate_x,locate_y,dir);
		this.tc = tc;
	}
	
	public void draw(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double missile = new Ellipse2D.Double(locate_x,locate_y,WIDTH,HEIGHT);
		g2.setPaint(Color.BLACK);
		g2.fill(missile);
		move();
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
		}
		if(locate_x > 800 || locate_y > 600 || locate_x < 0 || locate_y < 0)
			tc.missiles.remove(this);
	}
	
	
}
