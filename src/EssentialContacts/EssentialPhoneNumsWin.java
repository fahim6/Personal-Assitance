package EssentialContacts;

import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class EssentialPhoneNumsWin extends JFrame implements ActionListener{

    public EssentialPhoneNumsWin(){
        super();
    }
    JLabel line=new JLabel("Public Services     : :    ");
    String[] str={"Select an option","Hospitals & Clinic","RAB","Police","Fire Service","Blood Bank","Emergency Ambulance"};
    Font font1=new Font("Georgia",Font.BOLD,14);
    JComboBox options=new JComboBox(str);
    JTextField[] text=new JTextField[30];
    
    public JTextField newJF(){
    	JTextField textF=new JTextField();
        textF.setEditable(false);
        textF.setBackground(Color.decode("#000000"));
        textF.setForeground(Color.decode("#00CCCC"));
        textF.setFont(font1);
        textF.setHorizontalAlignment(JTextField.CENTER);
        return textF;
    }

    public void initGUI(){

    	super.setLayout(null);
    	
        line.setBounds(15,10,124,30);
        super.add(line);
        options.setBounds(145,10,170,30);
        super.add(options);
        for(int i=0; i<22; i++)
        	text[i]=newJF();
        text[0].setBounds(15,55,210,40);
        text[1].setBounds(249,55,210,40);
        text[2].setBounds(15,105,210,40);
        text[3].setBounds(249,105,210,40);
        text[4].setBounds(15,155,210,40);
        text[5].setBounds(249,155,210,40);
        text[6].setBounds(15,205,210,40);
        text[7].setBounds(249,205,210,40);
        text[8].setBounds(15,255,210,40);
        text[9].setBounds(249,255,210,40);
        text[10].setBounds(15,305,210,40);
        text[11].setBounds(249,305,210,40);
        text[12].setBounds(15,355,210,40);
        text[13].setBounds(249,355,210,40);
        text[14].setBounds(15,405,210,40);
        text[15].setBounds(249,405,210,40);
        text[16].setBounds(15,455,210,40);
        text[17].setBounds(249,455,210,40);
        text[18].setBounds(15,505,210,40);
        text[19].setBounds(249,505,210,40);
        text[20].setBounds(15,555,210,40);
        text[21].setBounds(249,555,210,40);
        options.addActionListener(this);
    }
    
    public void filePrint(String fileName){
    	try{
        	for(int i=0; i<22; i++)
        		super.add(text[i]);
    		text[0].setText(fileName.toUpperCase());
    		text[1].setText("CONTACTS");
			File f=new File(fileName+".txt");
			Scanner scanf=new Scanner(f);
			int k=2;
			while(scanf.hasNext()){
				String name=scanf.nextLine();
				String number=scanf.nextLine();
				text[k++].setText(name);
				text[k++].setText(number);
			}
		}
		catch(Exception ex){
			
		}
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==options){
        	String str=(String) options.getSelectedItem();
        	if(!str.equals("Select an option")){
        		filePrint(str);
        	}
        }
    }
}
