import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;


public class Chooser {

	public static void main(String[] args) {
		MyFrame1 frame = new MyFrame1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class MyFrame1 extends JFrame{
	
	private JFileChooser chooser;
	private JLabel label;
	public MyFrame1(){
		setSize(300,300);
		setTitle("FileChooser");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new OpenFileListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});	
		menu.add(openItem);
		menu.add(exitItem);
		label = new JLabel();
		add(label,BorderLayout.CENTER);
		chooser = new JFileChooser();
		ExtensionFilter filter = new ExtensionFilter();
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.addExtension("jpeg");
		filter.addExtension("jpg");
		filter.setDescription("Image files");
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreview(chooser));
		
	}
	
	private class OpenFileListener implements ActionListener{

		public void actionPerformed(ActionEvent event) {
			chooser.setCurrentDirectory(new File("C:\\Users\\Administrator\\Desktop"));
			int result = chooser.showOpenDialog(MyFrame1.this);
			if(result == JFileChooser.APPROVE_OPTION){
			String name = chooser.getSelectedFile().getPath();
			label.setIcon(new ImageIcon(name));
			}
		}		
	}
	
	class ImagePreview extends JLabel{
		
		public ImagePreview(JFileChooser chooser){
			setPreferredSize(new Dimension(100,100));
			setBorder(BorderFactory.createEtchedBorder());
			chooser.addPropertyChangeListener(new PropertyChangeListener() {			
				public void propertyChange(PropertyChangeEvent event) {
		
					if(event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
						File f = (File) event.getNewValue();
						if(f == null){setIcon(null);return;}
						ImageIcon icon = new ImageIcon(f.getPath());
						if(icon.getIconWidth() > getWidth()){
							icon = new ImageIcon(icon.getImage()
									.getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
						}
						setIcon(icon);
					}
				}
			});
		}
	}
	
	class ExtensionFilter extends FileFilter{

		private String decription = null;
		private ArrayList<String> extensions = new ArrayList<String>();
		public void addExtension(String extension){
			if(!extension.startsWith(".")){
				extension = "." + extension;
			}
			extensions.add(extension.toLowerCase());
		}
		public boolean accept(File file) {
			if(!file.isDirectory()) return true;
			String name = file.getName();
			for(String extension : extensions){
				if(name.endsWith(extension))
					return true;
			}
			return false;
		}
		
		public void setDescription(String aDescription){
			decription = aDescription;
		}

		public String getDescription() {
			return decription;
		}		
	} 
	
}
