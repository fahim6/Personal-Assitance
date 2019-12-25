package PersonalContacts;

import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class PersonalPhoneNumsWin extends JFrame implements ActionListener {

	public PersonalPhoneNumsWin() {
		super();
	}

	JLabel line = new JLabel("Options     : :    ");
	JLabel confirmation = new JLabel("");
	Font font1 = new Font("Verdana", Font.BOLD, 12);
	Font font2 = new Font("Georgia", Font.BOLD, 14);
	Font font3 = new Font("Time New Roman", Font.PLAIN, 14);
	JTextField[] text = new JTextField[30];
	JButton contacts = new JButton("Contacts");
	JButton newcon = new JButton("New");
	JButton edit = new JButton("Edit");
	JButton delete = new JButton("Delete");
	JButton find = new JButton("Find");
	JButton next = new JButton("Next");
	JButton add = new JButton("Add");
	JButton editcon = new JButton("Edit");
	JButton deletecon = new JButton("Delete");
	JButton findcon = new JButton("Find");
	int track=0;	//to check if there is any numbers

	public JTextField newJF() {
		JTextField textF = new JTextField();
		textF.setEditable(false);
		textF.setBackground(Color.decode("#000000"));
		textF.setForeground(Color.decode("#00CCCC"));
		textF.setFont(font1);
		textF.setHorizontalAlignment(JTextField.CENTER);
		return textF;
	}

	public void textFieldSetUp(){
		for (int i = 0; i < 12; i++)
			text[i] = newJF();
		text[0].setBounds(20, 45, 210, 35);
		text[1].setBounds(264, 45, 210, 35);
		text[2].setBounds(20, 90, 210, 35);
		text[3].setBounds(264, 90, 210, 35);
		text[4].setBounds(20, 135, 210, 35);
		text[5].setBounds(264, 135, 210, 35);
		text[6].setBounds(20, 180, 210, 35);
		text[7].setBounds(264, 180, 210, 35);
		text[8].setBounds(20, 225, 210, 35);
		text[9].setBounds(264, 225, 210, 35);
		text[10].setBounds(20, 270, 210, 35);
		text[11].setBounds(264, 270, 210, 35);
	}
	
	public void buttonDesign(JButton jb){
		jb.setFont(font1);
		jb.setBackground(Color.decode("#3D9970"));
		jb.setForeground(Color.decode("#FFFFFF"));
	}
	
	public void contactMet() {
		try {
			textFieldSetUp();
			File f = new File("Personal phone numbers.txt");
			Scanner scanf = new Scanner(f);
			for (int i = 0; i < 12; i++){
				super.add(text[i]);
				text[i].setText("");
			}
			text[0].setText("Name");
			text[1].setText("Number");
			int k = 2;
			for(int i=0; i<track; i++)
				scanf.nextLine();
			while (scanf.hasNextLine()) {//System.out.println(track);
				text[k++].setText(scanf.nextLine());
				text[k++].setText(scanf.nextLine());
				if ((k - 2) % 5 == 0)
					break;
			}
			track+=(k-2);
			if(!scanf.hasNextLine())
				track=0;
			super.add(next);
			scanf.close();
		} 
		catch (Exception ex) {

		}
	}
	
	public void newMet(){
		super.add(text[2]);
		text[2].setText("Contact Name");
		super.add(text[3]);
		text[3].setEditable(true);
		super.add(text[6]);
		text[6].setText("Contact Number");
		super.add(text[7]);
		text[7].setEditable(true);
		super.add(add);
		super.add(confirmation);
	}
	
	public void editMet(){
		newMet();
		super.remove(add);
		for(int i=6; i<10; i++)
			super.add(text[i]);
		text[6].setText("New Contact Name");
		text[8].setText("New Contact Number");
		text[5].setEditable(true);
		text[9].setEditable(true);
		super.add(editcon);
	}
	
	public void deleteMet(){
		text[4].setText("Contact Name");
		text[4].setEditable(false);
		super.add(text[4]);
		text[5].setEditable(true);
		super.add(text[5]);
		super.add(deletecon);
	}
	
	public void findMet(){
		newMet();
		text[7].setEditable(false);
		super.remove(add);
		super.add(findcon);
	}
	
	public void editanddelete(String buttonName){
		try{
			File f = new File("Personal phone numbers.txt");
			Scanner scanf = new Scanner(f);
			if(!text[3].getText().equals("") && !text[7].getText().equals("") && !text[9].getText().equals("")){
				String[] arr = new String[10000];
				int j=0;
				while(scanf.hasNextLine()){
					String str=scanf.nextLine();
					if(str.equals(text[3].getText()))
						scanf.nextLine();
					else arr[j++]=str;					
				}
				scanf.close();
				FileWriter fw = new FileWriter("Personal phone numbers.txt",false);
				for(int i=0; i<j; i++)
					fw.write(arr[i] + '\n');
				if(!buttonName.equals("deletecon"))
					fw.write(text[7].getText() + '\n' + text[9].getText());
				fw.close();
				confirmation.setText("* Contact Edited Successfully");
			}
			else
				confirmation.setText("* Fields Cannot Be Empty");
			text[3].setText("");
			text[7].setText("");
			text[9].setText("");
		}
		catch(Exception ex){
			
		}
	}
	
	public void refresh(){
		for(int i=0; i<12; i++){
			text[i].setText("");
			super.remove(text[i]);
		}
		confirmation.setText("");
		super.remove(next);
		super.remove(add);
		super.remove(editcon);
		super.remove(findcon);
		super.remove(deletecon);
		super.remove(confirmation);
		super.repaint();
	}

	public void initGUI() {
		super.setLayout(null);
		next.setBounds(352, 320, 120, 35);
		buttonDesign(next);
		add.setBounds(352, 260, 120, 35);
		buttonDesign(add);
		editcon.setBounds(352, 275, 120, 35);
		buttonDesign(editcon);
		deletecon.setBounds(352, 210, 120, 35);
		buttonDesign(deletecon);
		findcon.setBounds(352, 275, 120, 35);
		buttonDesign(findcon);
		confirmation.setBounds(20,260,220,35);
		confirmation.setFont(font3);
		contactMet();

		buttonDesign(contacts);
		contacts.setBounds(0, 0, 99, 30);
		buttonDesign(newcon);
		newcon.setBounds(99, 0, 99, 30);
		buttonDesign(edit);
		edit.setBounds(198, 0, 99, 30);
		buttonDesign(delete);
		delete.setBounds(297, 0, 99, 30);
		buttonDesign(find);
		find.setBounds(396, 0, 99, 30);

		super.add(contacts);
		super.add(newcon);
		super.add(edit);
		super.add(delete);
		super.add(find);

		contacts.addActionListener(this);
		newcon.addActionListener(this);
		editcon.addActionListener(this);
		deletecon.addActionListener(this);
		findcon.addActionListener(this);
		edit.addActionListener(this);
		delete.addActionListener(this);
		find.addActionListener(this);
		next.addActionListener(this);
		add.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Selected: " + e.getActionCommand());
		if (e.getSource() == contacts) {
			track=0;
			refresh();
			contactMet();
		}
		else if(e.getSource() == next){
			refresh();
			contactMet();
		}
		else if(e.getSource()==newcon){
			refresh();
			newMet();
		}
		else if(e.getSource()==add){
			try{
				FileWriter fw = new FileWriter("Personal phone numbers.txt",true);
				if(!text[3].getText().equals("") && !text[7].getText().equals("")){
					fw.append('\n' + text[3].getText() + '\n' + text[7].getText());
					confirmation.setText("* Contact Saved Successfully");
				}
				else
					confirmation.setText("* Fields Cannot Be Empty");
				fw.close();
				text[3].setText("");
				text[7].setText("");
			}
			catch(Exception ex){
				
			}
		}
		else if(e.getSource()==edit){
			refresh();
			editMet();
		}
		else if(e.getSource()==editcon){
			editanddelete("editcon");
		}
		else if(e.getSource()==delete){
			refresh();
			deleteMet();
		}
		else if(e.getSource()==deletecon){
			editanddelete("deletecon");
		}
		else if(e.getSource()==find){
			refresh();
			findMet();
		}
		else if(e.getSource()==findcon){
			try {
				File f = new File("Personal phone numbers.txt");
				Scanner scanf = new Scanner(f);
				if(!text[3].getText().equals("")){
					while(scanf.hasNextLine()){
						if(scanf.nextLine().equals(text[3].getText())){
							text[7].setText(scanf.nextLine());
							break;
						}
					}
					scanf.close();
				}
				else
					confirmation.setText("* Contact Name Cannot Be Empty");
			} 
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}