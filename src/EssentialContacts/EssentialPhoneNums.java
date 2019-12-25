package EssentialContacts;

import javax.swing.*;

public class EssentialPhoneNums{

    public EssentialPhoneNums(){	
    	EssentialPhoneNumsWin c=new EssentialPhoneNumsWin();
        c.setSize(480,635);
        c.setResizable(false);
        c.setLocation(450,50);
        c.setTitle("Essential Phone Numbers");
        c.initGUI();
        c.setVisible(true);
    }
}

