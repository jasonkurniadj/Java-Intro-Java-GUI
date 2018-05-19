package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/***
 * 
 * @author Jason.
 *
 */
public class Form extends JFrame implements ActionListener{
	private JPanel pnl_title, pnl_gender, pnl_detail, pnl_button;
	private JLabel lbl_title, lbl_name, lbl_gender, lbl_country;
	private JTextField txt_name;
	private JRadioButton rd_male, rd_female;
	private JComboBox cmb_country;
	private JCheckBox chx_agreement;
	private JButton btn_submit;
	
	void component(){
		lbl_title = new JLabel("Form");
		lbl_name = new JLabel("Name");
		lbl_gender = new JLabel("Gender");
		lbl_country = new JLabel("Country");
		
		lbl_title.setFont(new Font("Arial", Font.BOLD, 25));
		
		txt_name = new JTextField();
		
		rd_male = new JRadioButton("Male");
		rd_female = new JRadioButton("Female");
		
		rd_male.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd_male);
		bg.add(rd_female);
		
		String[] countryList = {"Choose", "Australia", "China", "Germany", "India", "Indonesia", "Korea", "Malaysia", "Singapore", "Spain", "United Arab Emirates", "United Kingdom", "United State"}; 
		cmb_country = new JComboBox(countryList);
		cmb_country.addActionListener(this);
		
		chx_agreement = new JCheckBox("I agree all rules.");
		
		btn_submit = new JButton("Submit");
		btn_submit.addActionListener(this);
		
		pnl_title = new JPanel();
		pnl_gender = new JPanel(new GridLayout(1, 2, 10, 10));
		pnl_detail = new JPanel(new GridLayout(5, 4, 10, 10));
		pnl_button = new JPanel();
		
		
		pnl_title.add(lbl_title);
		
		pnl_gender.add(rd_male);
		pnl_gender.add(rd_female);
		
		pnl_detail.add(lbl_name);
		pnl_detail.add(txt_name);
		pnl_detail.add(lbl_gender);
		pnl_detail.add(pnl_gender);
		pnl_detail.add(lbl_country);
		pnl_detail.add(cmb_country);
		pnl_detail.add(chx_agreement);
		
		pnl_button.add(btn_submit);
		
		
		add(pnl_title, "North");
		add(pnl_detail, "Center");
		add(pnl_button, "South");
	}
	
	void init(){
		setSize(400, 275);
		setTitle("Introduction to Java GUI | Form");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public Form() {
		component();
		init();
	}

	protected String name, gender, country;
	
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == btn_submit){
			name = txt_name.getText();
			country = cmb_country.getSelectedItem().toString();
			
			if(rd_male.isSelected())
				gender = "Male";
			else
				gender = "Female";
			
			if(name.equals("")){
				JOptionPane.showMessageDialog(this, "Name must be filled", "Warning!", JOptionPane.WARNING_MESSAGE);
				txt_name.requestFocus();
			}
			else if(country.equalsIgnoreCase("Choose")){
				JOptionPane.showMessageDialog(this, "Country must be choosed", "Warning!", JOptionPane.WARNING_MESSAGE);
				cmb_country.requestFocus();
			}
			else if(!chx_agreement.isSelected()){
				JOptionPane.showMessageDialog(this, "You must agree all statements", "Warning!", JOptionPane.WARNING_MESSAGE);
				chx_agreement.requestFocus();
			}
			else{
				this.setVisible(false);
				new Welcome();
			}
		}
	}

}
