package PersonalContacts;

import javax.swing.*;

public class PersonalPhoneNums{
	
    public PersonalPhoneNums(){	
    	PersonalPhoneNumsWin ppn=new PersonalPhoneNumsWin();
        ppn.setSize(500,400);
        ppn.setResizable(false);
        ppn.setLocation(450,150);
        ppn.setTitle("Personal Phone Numbers");
        ppn.initGUI();
        ppn.setVisible(true);
    }
}