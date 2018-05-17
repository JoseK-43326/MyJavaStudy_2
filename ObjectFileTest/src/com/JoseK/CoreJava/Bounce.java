package com.JoseK.CoreJava;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.*;

public class Bounce {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0)
				;
			}
			
		});
		frame.setVisible(true);
	}

}

class Ball{
	
	private double x = 0;
	private double y = 0;
	private static double dx = 1;
	private static double dy = 1;
	private static final double XSIZE = 15;
	private static final double YSIZE = 15;	
	
	public void move(Rectangle2D bounds){
		x = x + dx;
		y = y + dy;
		if(x < bounds.getMinX()){
			x = bounds.getMinX();
			dx = -dx;
		}
		if(x + XSIZE > bounds.getMaxX()){
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if(y < bounds.getMinY()){
			y = bounds.getMinY();
			dy = -dy;
		}
		if(y + YSIZE > bounds.getMaxY()){
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
			
	}
	
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}
	
}

class MyPanel extends JPanel{
	
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public void add(Ball b){
		balls.add(b);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for(Ball b : balls)
			g2.fill(b.getShape());
	}
	
	
}

class MyFrame extends JFrame{
	
	private MyPanel panel;
	
	public MyFrame(){
		
		setSize(300, 300);
		setTitle("Bounce");
		panel = new MyPanel();
		add(panel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		add(buttonPanel,BorderLayout.SOUTH);
		addButton(buttonPanel, "Start",new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				addBall();
			}
		});
		addButton(buttonPanel, "Close", new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
	}	
	private void addButton(JPanel panel, String name, ActionListener listener){
		JButton button = new JButton(name);
		button.addActionListener(listener);
		panel.add(button);
	}
	
	public void addBall(){
		Ball ball = new Ball();
		panel.add(ball);
		BallThread r = new BallThread(panel,ball);
		Thread t = new Thread(r);
		t.start();
	}	
}

class BallThread implements Runnable{
	
	private static final int STEP = 1000;
	private static final int DELAY = 3;
	private JPanel panel;
	private Ball ball;
	
	public BallThread(JPanel aPanel, Ball aBall) {
		panel = aPanel;
		ball = aBall;
	}

	public void run() {
		for(int i = 1; i < STEP; i++){
			ball.move(panel.getBounds());
			panel.repaint();
			try {
				Thread.sleep(DELAY);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
