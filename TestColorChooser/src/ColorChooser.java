import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ColorChooser {

	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MyFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MyFrame(){
		setSize(300,300);
		setTitle("ColorChooser");
		MyPanel panel = new MyPanel();
		add(panel);
	}
}

class MyPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public MyPanel(){
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		
		JButton modalessButton = new JButton("Modaless");
		modalessButton.addActionListener(new ModalessListener());
		add(modalessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
		
	}
	
	private class ModalListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			Color defaultColor = getBackground();
			Color selectedColor = JColorChooser.showDialog(MyPanel.this
					,"Background" , defaultColor);
			if(selectedColor != null) setBackground(selectedColor);
		}		
	}
	
	private class ModalessListener implements ActionListener{
		private JColorChooser chooser;
		private JDialog dialog;
		public ModalessListener(){
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(MyPanel.this, "Background", false,
					chooser, new ActionListener() {					
						public void actionPerformed(ActionEvent event) {
							setBackground(chooser.getColor());
						}}, null);
			
		}
		
		public void actionPerformed(ActionEvent event) {
			//chooser.setColor(getBackground());
			dialog.setVisible(true);
		}		
	}
	
	private class ImmediateListener implements ActionListener{
		private JColorChooser chooser;
		private JDialog dialog;
		public ImmediateListener(){
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(new ChangeListener() {			
				public void stateChanged(ChangeEvent event) {
					setBackground(chooser.getColor());
				}
			});
			dialog = new JDialog((MyFrame)null,false);
			dialog.add(chooser);
			dialog.pack();
		}
		public void actionPerformed(ActionEvent arg0) {
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}		
	}
	
}