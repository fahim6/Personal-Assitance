package Credits;

import javax.swing.*;

public class Credits{

    public Credits(){
    	CreditsWin aw = new CreditsWin();
        aw.setSize(480,450);
        aw.setResizable(false);
        aw.setLocation(450,150);
        aw.setTitle("Credits");
        aw.initGUI();
        aw.setVisible(true);
    }
}