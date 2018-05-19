package main;

import java.awt.*;
import javax.swing.*;

/***
 * 
 * @author Jason.
 *
 */
public class Welcome extends JFrame{
	private JPanel pnl;
	private JLabel lbl;
	
	void component(){
		lbl = new JLabel("WELCOME");
		lbl.setFont(new Font("Arial", Font.BOLD, 30));
		
		pnl = new JPanel();
		pnl.add(lbl);
		
		add(pnl, "Center");
	}
	
	void init(){
		setSize(400, 100);
		setTitle("Introduction to Java GUI | Welcome");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public Welcome() {
		component();
		init();
	}
	
}
