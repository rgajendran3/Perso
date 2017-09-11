package perso;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Desktop;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Perso {

	private JFrame frame;
	public Terminal terminal;
	public JPanel buttonBoxPanel,Bookmark;
	public JDialog mydialog;
	public Bookmark book;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perso window = new Perso();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Perso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Perso ( 1.0 ) by Gaju");
		frame.setBounds(100, 100, 366, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		//Windows---------------------------------------------------------------------------------------------------------------------->
		JPanel panel = new JPanel();
		buttonBoxPanel = new JPanel();
		
		tabbedPane.addTab("Windows", null, panel, null);

		buttonBoxPanel.setLayout(new GridLayout(0,2,1,1));
		panel.setLayout(new GridLayout(0,1));

		ScrollPane scrollPane = new ScrollPane();
		String[] btnNames = Support.GenerateBtn();
		for(int i =0; i < btnNames.length; i++){
			JButton button = new JButton(btnNames[i]);
			button.addActionListener(new Listener());
			buttonBoxPanel.add(button);
		}
		scrollPane.add(buttonBoxPanel);
		
		panel.add(scrollPane);

		JPanel terminalPanel = new JPanel();
		terminalPanel.setLayout(new BorderLayout());
		tabbedPane.addTab("Terminal", null, terminalPanel, null);
		terminal = new Terminal(terminalPanel);
		//Bookmark-------------------------------------------------------------------------------------------------------------------------->
		Bookmark = new JPanel();
		JPanel addBook = new JPanel();
		//Bookmark.setLayout(new BorderLayout());
		tabbedPane.addTab("Pending", null, Bookmark, null);
		tabbedPane.addTab("+", null, addBook, null);
		addBook.setLayout(null);
		
		JLabel lblHeadings = new JLabel("Headings");
		lblHeadings.setBounds(29, 35, 68, 14);
		addBook.add(lblHeadings);
		
		textField = new JTextField();
		textField.setBounds(107, 32, 204, 20);
		addBook.add(textField);
		textField.setColumns(10);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setBounds(29, 90, 46, 14);
		addBook.add(lblNotes);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(29, 115, 282, 266);
		addBook.add(textPane);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final String FILENAME = "D:\\Perso\\perso.txt";
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter out = null;
				try {
				    fw = new FileWriter(FILENAME, true);
				    bw = new BufferedWriter(fw);
				    out = new PrintWriter(bw);
				    if(!textField.getText().isEmpty() && !textPane.getText().isEmpty())
				    {
				    	out.println(textField.getText()+" ` "+textPane.getText());
				    	out.close();
				    }				  
				} catch (IOException e) {
				    //exception handling left as an exercise for the reader
				}
			}
		});
		btnAdd.setBounds(222, 407, 89, 23);
		addBook.add(btnAdd);
		
		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				textField.setText("");
			}
		});
		button.setBounds(29, 407, 89, 23);
		addBook.add(button);
		book = new Bookmark(Bookmark);
		
		//tabbed pane listener
		tabbedPane.addChangeListener(new ChangeListener() {		
			@Override
			public void stateChanged(ChangeEvent e) {
				if(tabbedPane.getSelectedIndex() == 2){
					book = new Bookmark(Bookmark);
				}
			}
		});
			
	}
	
	public class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch(e.getActionCommand()){
				case "C:/":
						try{
							Desktop desktop = Desktop.getDesktop();
						 	File dirToOpen = new File("C:\\");
						 	desktop.open(dirToOpen);
						}catch(IOException ex){
							Support.showError(ex.getMessage());
						}
					 	
					break;
					
				case "Drive":	
					try{
						Desktop desktop = Desktop.getDesktop();
					 	File dirToOpen = new File("D:\\");
					 	desktop.open(dirToOpen);
					}catch(IOException ex){
						Support.showError(ex.getMessage());
					}
		
					break;
					
				case "Personal":
					try{
						Desktop desktop = Desktop.getDesktop();
					 	File dirToOpen = new File("G:\\");
					 	desktop.open(dirToOpen);
					}catch(IOException ex){
						Support.showError(ex.getMessage());
					}
					break;
				
				case "MyBeckett":
					try{
						Desktop.getDesktop().browse(new URL("https://my.leedsbeckett.ac.uk/webapps/login/").toURI());
					}catch(Exception ex){
						Support.showError(ex.getMessage());
					}
					break;
					
				case "Staff Mail":
					try{
						Desktop.getDesktop().browse(new URL("https://lbmail.leedsbeckett.ac.uk/owa/auth/logon.aspx").toURI());
					}catch(Exception ex){
						Support.showError(ex.getMessage());
					}
					break;	
				
				case "Staff Claim":
					try{
						Desktop.getDesktop().browse(new URL("https://vts.leedsbeckett.ac.uk/").toURI());
					}catch(Exception ex){
						Support.showError(ex.getMessage());
					}
					break;	
					
				case "LogIn":
					String input = JOptionPane.showInputDialog("Enter your password : ");
					if(input.equals("pass")){
						MyPrograms.NewProgram();
						
					}else{
						Support.showError("Incorrect Password");
					}
					break;		
					
				case "Google Drive":
					try{
						Desktop.getDesktop().browse(new URL("https://drive.google.com/drive/my-drive").toURI());
					}catch(Exception ex){
						Support.showError(ex.getMessage());
					}
					break;	
					
				case "Bookmark":
					String pass = JOptionPane.showInputDialog("Enter your password");
					if(pass.equals("Secret")){
						Site.NewSite();						
					}else{
						Support.showError("Incorrect Password");
					}
					break;
				
				case "Eclipse":
					try {
						Runtime runTime = Runtime.getRuntime();
						Process process = runTime.exec("D:\\System Software\\Eclipse\\eclipse\\eclipse");
						try {
							Thread.sleep(5000);
						} catch (InterruptedException interupt) {
							Support.showError(interupt.getMessage());
						}
						process.destroy();
					} catch (IOException ex) {
						Support.showError(ex.getMessage());
					}
					break;
				
			}
			
		}
		
	}
}
