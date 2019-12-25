package Calculator;

import javax.swing.*;

public class Calculator{

    public Calculator(){
        CalculatorWin c=new CalculatorWin();
        c.setSize(268,349);
        c.setResizable(false);
        c.setLocation(550,200);
        c.setTitle("Calculator");
        c.initGUI();
        c.setVisible(true);
    }
}
