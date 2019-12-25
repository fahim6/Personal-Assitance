package Converter;

import javax.swing.JFrame;

public class Converter {

	public Converter(){
		ConverterWin cw=new ConverterWin();
		cw.setSize(400,300);
		cw.setLocation(500,200);
		cw.setResizable(false);
		cw.setTitle("Converter");
		cw.initGUI();
		cw.setVisible(true);
	}
}
