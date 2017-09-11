package perso;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Support {

	public static void showError(String error){
		JOptionPane.showMessageDialog(null, error);
	}
	
	public static String[] GenerateBtn(){
	
		List<String> fileLine = new ArrayList<String>();
		final String FILENAME = "D:\\Perso\\button.txt";
		String[] values = null;
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		JList<String> list = new JList<>(listModel);
		list.removeAll();
		try {
			FileInputStream fis = new FileInputStream(FILENAME);

			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		 
			String line = null;
			while ((line = br.readLine()) != null) {
				fileLine.add(line);
			}			
			values = fileLine.toArray(new String[0]);
		   
			br.close();
		} catch (Exception ex) {
			showError(ex.getMessage());
		}
		
		return values;
	}
	
}
