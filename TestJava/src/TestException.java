import java.awt.TextField;
import java.awt.event.*;

import javafx.scene.text.Text;

import javax.swing.*;





public class TestException {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class MyFrame extends JFrame{
	
	public MyFrame(){
		
		setTitle("TestException");
		setSize(300,300);
		MyPanel panel = new MyPanel();
		add(panel);
	}	
}

class MyPanel extends Box{
	private ButtonGroup group;
	private JTextField textField;
	private double[] a = new double[10];
	public MyPanel(){
		super(BoxLayout.Y_AXIS);
		group = new ButtonGroup();
		
		addButton("Integer divided by zero", new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				a[1] = 1 / (a.length - a.length);
			}
		});
		
		textField = new JTextField(30);
		add(textField);
	}
	
	private void addButton(String s , ActionListener listener){
		JRadioButton button = new JRadioButton(s, false){
			protected void fireActionPerformed(ActionEvent event){
				try {
					textField.setText("No Exception");
					super.fireActionPerformed(event);
				} catch (Exception e) {
					textField.setText(e.toString());
				}
			}
		};
		button.addActionListener(listener);
		add(button);
		group.add(button);
		
	}
	
}
