package perso;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;

public class MyPrograms {

	JFrame frame;
	public static Support support;

	/**
	 * Launch the application.
	 */
	public static void NewProgram() {
		support = new Support();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyPrograms window = new MyPrograms();
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
	public MyPrograms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("My Programs");
		frame.getContentPane().setLayout(new GridLayout(0, 2, 2, 2));
		
		JButton btn1 = new JButton("Deivamagal");		
		JButton btn2 = new JButton("Priyamanaval");		
		JButton btn3 = new JButton("Vaani Raani");
		JButton btn4 = new JButton("Kalyanam Mudhal");
		JButton btn5 = new JButton("Saravanan Meenakshi");
		JButton btn6 = new JButton("Pagal Nilavu");
		JButton btn7 = new JButton("Mapillai");
		JButton btn8 = new JButton("Seedhayin Raaman");
		JButton btn9 = new JButton("Neeya Naana");
		
		frame.getContentPane().add(btn1);
		frame.getContentPane().add(btn2);
		frame.getContentPane().add(btn3);
		frame.getContentPane().add(btn4);
		frame.getContentPane().add(btn5);
		frame.getContentPane().add(btn6);
		frame.getContentPane().add(btn7);
		frame.getContentPane().add(btn8);
		frame.getContentPane().add(btn9);
		
		btn1.addActionListener(new Listener());
		btn2.addActionListener(new Listener());
		btn3.addActionListener(new Listener());
		btn4.addActionListener(new Listener());
		btn5.addActionListener(new Listener());
		btn6.addActionListener(new Listener());
		btn7.addActionListener(new Listener());
		btn8.addActionListener(new Listener());
		btn9.addActionListener(new Listener());
		
	}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Deivamagal":
				try{
					Desktop.getDesktop().browse(new URL("https://www.youtube.com/user/VikatanTV/videos").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Priyamanaval":
				try{
					Desktop.getDesktop().browse(new URL("https://www.youtube.com/user/VikatanTV/videos").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Vaani Raani":
				try{
					Desktop.getDesktop().browse(new URL("https://www.youtube.com/user/RadaanMedia/videos").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
			
			case "Kalyanam Mudhal":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/kalyanam-mudhal-kaadhal-varai/1688").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Saravanan Meenakshi":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/saravanan-meenatchi/1678").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Pagal Nilavu":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/pagal-nilavu/8911").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Mapillai":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/maapillai/11856").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Seedhayin Raaman":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/seedhayin-raaman/7016").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;
				
			case "Neeya Naana":
				try{
					Desktop.getDesktop().browse(new URL("http://www.hotstar.com/tv/neeya-naana/1584").toURI());
				}catch(Exception ex){
					Support.showError(ex.getMessage());
				}
				break;	
			}
			
		}
		
	}

}
