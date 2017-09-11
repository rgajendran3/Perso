package perso;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class Bookmark {

	public String[] values;
	private DefaultListModel<String> listModel;
	public JTextArea textarea;
	public JList<String> list;
	public Bookmark(JPanel panel){
		panel.setLayout(new BorderLayout());
		JPanel container = new JPanel();
		
		container.setLayout(new BorderLayout());	
		List<String> fileLine = new ArrayList<String>();
		final String FILENAME = "D:\\Perso\\perso.txt";
		FileInputStream fis;
		listModel = new DefaultListModel<String>();
		list = new JList<>(listModel);
		list.removeAll();
		try {
			fis = new FileInputStream(FILENAME);

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("`");
				fileLine.add(split[1]);
				listModel.addElement(split[0]);
			}			
		    values = fileLine.toArray(new String[0]);
		   
			br.close();
		} catch (Exception ex) {
			Support.showError(ex.getMessage());
		}
		
		JScrollPane listscroll = new JScrollPane(list);
		textarea = new JTextArea();
		textarea.setEditable(false);
		JScrollPane textscroll = new JScrollPane(textarea);
		container.add(listscroll, BorderLayout.NORTH);
		container.add(textscroll, BorderLayout.CENTER);
		panel.add(container);
		list.addListSelectionListener(new MyListDataListener());
		//secondValue.addListSelectionListener(new MyListDataListener());
			
	}
	
	class MyListDataListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			textarea.setText(values[list.getSelectedIndex()]);			
		}
		
	}
}
