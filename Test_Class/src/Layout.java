import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Layout{
	public static void main(String[] args){
		Layout gui = new Layout();
		gui.go();
		}
	public void go(){
		String[] a = {"–°∫ÀµØ1","∑Æ¥Ã‚¨1","–°∫ÀµØ2","∑Æ¥Ã‚¨2"};
		JFrame frame = new JFrame();
		//JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		final JList list = new JList(a);
		//JButton button = new JButton("Click me");
		//JTextArea text = new JTextArea(10, 20);
		//JScrollPane scroller = new JScrollPane(text);
		JScrollPane scroller2 = new JScrollPane(list);
		
		//panel.add(scroller);
		panel2.add(scroller2);
		
		//text.setLineWrap(true);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionMode.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent Ise){
				if(!Ise.getValueIsAdjusting()){
					String selection = (String) list.getSelectedValue();
					System.out.println(selection);
					
					}
				}
			
			});
		
		/*scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	*/	
		scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		/*frame.getContentPane().add(panel);*/
		frame.getContentPane().add(panel2);
		
	/*	frame.getContentPane().add(BorderLayout.SOUTH, button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				text.append("Button Clicked \n");
				}
			});*/
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		}
	}
