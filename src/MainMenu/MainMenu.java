package MainMenu;

import javax.swing.*;

public class MainMenu{

    public static void main(String[] args){	
    	MainMenuWin mmw = new MainMenuWin();
        mmw.setSize(600,270);
        mmw.setResizable(false);
        mmw.setLocation(400,170);
        mmw.setTitle("Personal Assistance");
        mmw.initGUI();
        mmw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mmw.setVisible(true);
    }
}