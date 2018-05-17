import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class TestZip {

	public static void main(String[] args) {
		ZipFrame frame = new ZipFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}			
		});
		frame.setVisible(true);
	}

}

class ZipFrame extends JFrame{
	
	private JTextArea text;
	private JComboBox fileCombo;
	private String zipName;
	
	public ZipFrame(){
		setTitle("ZipTest");
		setSize(300, 300);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("E:\\java\\Image\\Doc.png"));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new OpenListener());
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
		}});
		menu.add(openItem);
		menu.add(exitItem);
		
		text = new JTextArea();
		JScrollPane scroll = new JScrollPane(text);
		fileCombo = new JComboBox();
		fileCombo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				loadFile((String) fileCombo.getSelectedItem());
			}
		});
		
		add(scroll ,BorderLayout.CENTER);
		add(fileCombo,BorderLayout.SOUTH);
	}
	
	class OpenListener implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("."));
			ExtensionFilter filter = new ExtensionFilter();
			filter.addExtension("zip");
			filter.addExtension("jar");
			filter.setDescription("ZIP Achieve");
			chooser.setFileFilter(filter);
			int r = chooser.showOpenDialog(ZipFrame.this);
			if(r == JFileChooser.APPROVE_OPTION){
				zipName = chooser.getSelectedFile().getPath();
				scanFile();
			}				
		}		
	}
	
	public void scanFile(){
		
		fileCombo.removeAllItems();
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
			ZipEntry entry;
			while((entry = zin.getNextEntry()) != null){
				fileCombo.addItem(entry.getName());
				zin.closeEntry();
			}
			zin.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void loadFile(String name){
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(zipName));
			ZipEntry entry;
			text.setText("");
			while((entry = zin.getNextEntry()) != null){
				if(entry.getName().equals(name)){
					BufferedReader in = new BufferedReader(new InputStreamReader(zin));
					String line;
					while((line = in.readLine()) != null){
						text.append(line);
						text.append("\n");
					}
				}
				zin.closeEntry();	
			}
			zin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	class ExtensionFilter extends FileFilter{
		
		private String description;
		private ArrayList<String> extensions = new ArrayList<String>();
		
		public void addExtension(String extension){
			if(!extension.startsWith("."))
				extension = "." + extension;
			extensions.add(extension);
		}
		public boolean accept(File file) {
			if(file.isDirectory()) return true;
			String name = file.getName().toLowerCase();
			for(String extension : extensions){
				if(name.endsWith(extension))
					return true;
			}
			return false;
		}		
		public void setDescription(String aDescription){
			description = aDescription;
		}
		public String getDescription() {
			return description;
		}		
	}
	
}