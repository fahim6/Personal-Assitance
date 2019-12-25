package Converter;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class ConverterWin extends JFrame implements ActionListener{
	public ConverterWin(){
		super();
}
	String[] opString1={"Inches","Degree","Kilo-Meter","Celsius","Meter","Radian","Mile","Fahrenheit"};
	String[] opString2={"Meter","Radian","Mile","Fahrenheit","Inches","Degree","Kilo-Meter","Celsius"};
	JComboBox opCombo1=new JComboBox(opString1);
	JTextField op1=new JTextField();
	JComboBox opCombo2=new JComboBox(opString2);
	JButton convert=new JButton("CONVERT");
	JTextField convertField=new JTextField();
	JButton back=new JButton("Back");
	public void initGUI(){
		
		JLabel value=new JLabel("Value");
		JLabel convertlabel=new JLabel("Convert From");
		JLabel tolabel=new JLabel("To");
		super.setLayout(null);
		value.setBounds(72,20,50,10);
		super.add(value);
		opCombo1.setBounds(210,20,150,30);
		super.add(opCombo1);
		op1.setBounds(25,40,150,30);
		super.add(op1);
		opCombo2.setBounds(210,70,150,30);
		super.add(opCombo2);
		convert.setBounds(110,150,150,30);
		super.add(convert);
		convertField.setBounds(110,190,150,30);
		super.add(convertField);
		convert.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==convert){
			String a=opCombo1.getSelectedItem().toString();
			String b=opCombo2.getSelectedItem().toString();
			if(a.equals("Inches")&&b.equals("Meter")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=v/39.370;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Meter")&&b.equals("Inches")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=v*39.370;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Degree")&&b.equals("Radian")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=(v*Math.PI)/180;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Radian")&&b.equals("Degree")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=(v*180)/Math.PI;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Kilo-Meter")&&b.equals("Mile")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=v*0.621371;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Mile")&&b.equals("Kilo-Meter")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=v/0.621371;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Celsius")&&b.equals("Fahrenheit")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=(v*1.8)+32;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else if(a.equals("Fahrenheit")&&b.equals("Celsius")){
				String s=op1.getText();
				double v=Double.parseDouble(s);
				double con=(v-32)*.556;
				String conValue=con+"";
				convertField.setText(conValue);
			}
			else{
				convertField.setText("Invalid Option choosed");
			}		
		}
	}
}
