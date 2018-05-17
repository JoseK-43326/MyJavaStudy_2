import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;



public class VisualCalendar {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}			
		});
		frame.setVisible(true);;   	
	}
}

class MyFrame extends JFrame{
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 300;
	
	public MyFrame(){		
		setSize(WIDTH,HEIGHT);
		setTitle("VisualCalendar");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\calendar.png"));
		setResizable(false);
		MyPanel panel = new MyPanel();	
		panel.text = new JTextArea();
		panel.text.setLineWrap(true);
		panel.setVisualCalendar();
		add(panel,BorderLayout.NORTH);
		add(panel.text,BorderLayout.CENTER);
	}
	
}

class MyPanel extends JPanel{
	
	public JButton backButton;
	public JButton nextButton;
	public JButton yearButton;
	public JLabel yearLabel;
	public JButton monthButton;
	public JLabel monthLabel;
	public JTextArea text;
	private static int monthInt;
	private static int yearInt;
	private String monthString =   
			String.valueOf((new GregorianCalendar().get(Calendar.MONTH)+1));
	private String yearString = 
			String.valueOf(new GregorianCalendar().get(Calendar.YEAR));
	Calendar calendar1 = new GregorianCalendar();
	
	public MyPanel(){
		setLayout(new GridLayout(1,6));
		backButton = new JButton("Back");
		nextButton = new JButton("Next");
		yearButton = new JButton(yearString);
		yearButton.setEnabled(false);
		yearLabel = new JLabel("年",JLabel.CENTER);
		monthButton = new JButton(monthString);
		monthButton.setEnabled(false);
		monthLabel = new JLabel("月",JLabel.CENTER);
		add(backButton);
		add(yearButton);
		add(yearLabel);
		add(monthButton);
		add(monthLabel);
		add(nextButton);
		nextButton.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				monthString  = monthButton.getText();
				yearString = yearButton.getText();
				monthInt = Integer.parseInt(monthString);
				yearInt = Integer.parseInt(yearString);
				monthInt++;
				if(monthInt > 12) {
					monthInt = 1;
					monthButton.setText("1");
					yearInt = yearInt + 1;
					yearButton.setText(String.valueOf(yearInt));
				}else{
					monthButton.setText(String.valueOf(monthInt));
				}				
				text.append("日\t一\t二\t三\t四\t五\t六");	
//System.out.println("--->" + yearInt);
				Calendar calendar = new GregorianCalendar(yearInt,monthInt-1,calendar1.get(Calendar.DAY_OF_MONTH));
//System.out.println(calendar.get(Calendar.YEAR));
				int today = calendar.get(Calendar.DAY_OF_MONTH);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
			    int	weekday = calendar.get(Calendar.DAY_OF_WEEK);
			    if(weekday == 1) 
			    	{
			    		text.append("\r\n");
			    	}else {
					    for(int i = 1; i < weekday; i++)
					    	text.append("\t");
			    	}
			    for(int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			    	calendar.set(Calendar.DAY_OF_MONTH,i);
			    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			    	if(dayOfWeek < 7) {
			    		if(i == today){
			    			text.append(String.valueOf(i) + "*");
			    			text.append("\t");
			    		}else{
			    			text.append(String.valueOf(i));
			    			text.append("\t");
			    		}
			    		
			    	}else{
			    		if(i == today){	    			
			    			text.append(String.valueOf(i)+"*");
			    			text.append("\r\n");
			    		}else{
			    			text.append(String.valueOf(i));
			    			text.append("\r\n");
			    		}	
			    	}	
			    }
			}
		});
		backButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				text.setText("");
				monthString  = monthButton.getText();
				yearString = yearButton.getText();
				monthInt = Integer.parseInt(monthString);
				yearInt = Integer.parseInt(yearString);
				monthInt--;
				if(monthInt < 1) {
					monthInt = 12;
					monthButton.setText("12");
					yearInt = yearInt - 1;
					yearButton.setText(String.valueOf(yearInt));
				}else{
					monthButton.setText(String.valueOf(monthInt));
				}
				text.append("日\t一\t二\t三\t四\t五\t六");			
				Calendar calendar = new GregorianCalendar(yearInt,monthInt-1,calendar1.get(Calendar.DAY_OF_MONTH));
//System.out.println(calendar.get(Calendar.YEAR));
				int today = calendar.get(Calendar.DAY_OF_MONTH);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
			    int	weekday = calendar.get(Calendar.DAY_OF_WEEK);
			    if(weekday == 1) 
			    	{
			    		text.append("\r\n");
			    	}else {
					    for(int i = 1; i < weekday; i++)
					    	text.append("\t");
			    	}
			    for(int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
			    	calendar.set(Calendar.DAY_OF_MONTH,i);
			    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			    	if(dayOfWeek < 7) {
			    		if(i == today){
			    			text.append(String.valueOf(i) + "*");
			    			text.append("\t");
			    		}else{
			    			text.append(String.valueOf(i));
			    			text.append("\t");
			    		}
			    		
			    	}else{
			    		if(i == today){	    			
			    			text.append(String.valueOf(i)+"*");
			    			text.append("\r\n");
			    		}else{
			    			text.append(String.valueOf(i));
			    			text.append("\r\n");
			    		}	
			    	}	
			    }
			}			
		});
	}
	
	public void setVisualCalendar(){
		text.append("日\t一\t二\t三\t四\t五\t六");
		Calendar calendar1 = new GregorianCalendar();
		Calendar calendar = new GregorianCalendar(yearInt,monthInt,calendar1.get(Calendar.DAY_OF_MONTH));
		int today = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
	    int	weekday = calendar.get(Calendar.DAY_OF_WEEK);
	    for(int i = 1; i < weekday; i++ )
	    	text.append("\t");
	    for(int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
	    	calendar.set(Calendar.DAY_OF_MONTH,i);
	    	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
	    	if(dayOfWeek < 7) {
	    		if(i == today){
	    			text.append(String.valueOf(i) + "*");
	    			text.append("\t");
	    		}else{
	    			text.append(String.valueOf(i));
	    			text.append("\t");
	    		}
	    		
	    	}else{
	    		if(i == today){	    			
	    			text.append(String.valueOf(i)+"*");
	    			text.append("\r\n");
	    		}else{
	    			text.append(String.valueOf(i));
	    			text.append("\r\n");
	    		}	
	    	}	
	    }
	}
	
}
