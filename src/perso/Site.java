package perso;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class Site {

	private JFrame frame;
	public static Support support;

	/**
	 * Launch the application.
	 */
	public static void NewSite() {
		support = new Support();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Site window = new Site();
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
	public Site() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Private Links");
		frame.getContentPane().setLayout(new GridLayout(0, 2, 2, 2));
		
		JButton btn1 = new JButton("Site1");
		JButton btn2 = new JButton("Site2");
		JButton btn3 = new JButton("Site1 (I)");		
		JButton btn4 = new JButton("Site1 (J)");
		JButton btn5 = new JButton("Site2 (I)");		
		JButton btn6 = new JButton("Site2 (J)");	
		
		
		frame.getContentPane().add(btn1);
		frame.getContentPane().add(btn2);
		frame.getContentPane().add(btn3);
		frame.getContentPane().add(btn4);
		frame.getContentPane().add(btn5);
		frame.getContentPane().add(btn6);

		
		btn1.addActionListener(new Listener());
		btn2.addActionListener(new Listener());
		btn3.addActionListener(new Listener());
		btn4.addActionListener(new Listener());
		btn5.addActionListener(new Listener());
		btn6.addActionListener(new Listener());
		
	}
	
	public class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "Site1":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s1.com");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;
				
			case "Site2":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s2.com");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;
				
			case "Site1 (I)":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s2.html");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;
				
			case "Site1 (J)":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s3.html");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;	
				
			case "Site2 (I)":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s4.html");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;
				
			case "Site2 (J)":
				try {
					ProcessBuilder process = new ProcessBuilder("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","-incognito","http://s5.html");
					process.start();
				} catch (Exception e1) {
					Support.showError(e1.getMessage());
				}
				break;	
			}
			
		}
		
	}
}
