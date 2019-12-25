package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import Calculator.*;
import Converter.*;
import Credits.*;
import EssentialContacts.*;
import PersonalContacts.*;


public class MainMenuWin extends JFrame implements ActionListener {

	public MainMenuWin() {
		super();
	}
	JTextField textF = new JTextField();
	JTextField day = new JTextField();
	JTextField month = new JTextField();
	JTextField year = new JTextField();
	Font font1 = new Font("Algerian", Font.BOLD, 30);
	Font font2 = new Font("Verdana", Font.BOLD, 14);
	JButton[] options = new JButton[10];

	public JButton newJF() {
		JButton textF = new JButton();
		textF.setBackground(Color.decode("#3D9970"));
		textF.setForeground(Color.decode("#FFFFFF"));
		textF.setFont(font2);
		return textF;
	}

	public void initGUI() {
		super.setLayout(null);
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String d = calendar.get(Calendar.DATE) + "";
		String m = (calendar.get(Calendar.MONTH)+1) + "";
		String y = calendar.get(Calendar.YEAR) + "";
		day.setBounds(210, 100, 175, 50);
		day.setEditable(false);
		day.setBackground(Color.decode("#3D9970"));
		day.setForeground(Color.decode("#FFFFFF"));
		day.setFont(font2);
		day.setText( d + "  |  " + m + "  |  " + y);
		day.setHorizontalAlignment(JTextField.CENTER);
		super.add(day);
		
		textF.setBounds(0,0,600,80);
		textF.setEditable(false);
        textF.setBackground(Color.decode("#000000"));
        textF.setForeground(Color.decode("#00CCCC"));
        textF.setFont(font1);
        textF.setHorizontalAlignment(JTextField.CENTER);
        textF.setText("Personal Assistance");
		super.add(textF);
		for(int i=0; i<10; i++)
			options[i]=newJF(); 
		options[0].setBounds(20, 100, 175, 50);
		options[0].setText("Calculator");
		options[1].setBounds(20, 180, 175, 50);
		options[1].setText("Personal Contacts");
		options[5].setBounds(400, 180, 175, 50);
		options[5].setText("Essential Contacts");
		options[6].setBounds(400, 100, 175, 50);
		options[6].setText("Converter");
		options[7].setBounds(210, 180, 175, 50);
		options[7].setText("Credits");
		for(int i=0; i<8; i++){
			super.add(options[i]);
			options[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == options[0]) {
			Calculator calc = new Calculator();
		}
		else if(e.getSource() == options[1]) {
			PersonalPhoneNums pcn = new PersonalPhoneNums();
		}
		
		else if(e.getSource() == options[5]) {
			EssentialPhoneNums ep = new EssentialPhoneNums();
		}
		else if(e.getSource() == options[6]) {
			Converter conv = new Converter();
		}
		else if(e.getSource() == options[7]) {
			Credits cred = new Credits();
		}
		
	}
}
