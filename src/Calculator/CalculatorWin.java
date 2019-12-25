package Calculator;

import javax.swing.*;
import java.math.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class CalculatorWin extends JFrame implements ActionListener{

    public CalculatorWin(){
        super();
    }
    Font font1 = new Font("Verdana", Font.BOLD, 14);
    JTextField display=new JTextField("0");
    JLabel title=new JLabel("CALCULATOR");
    JButton one=new JButton("1");
    JButton two=new JButton("2");
    JButton three=new JButton("3");
    JButton four=new JButton("4");
    JButton five=new JButton("5");
    JButton six=new JButton("6");
    JButton seven=new JButton("7");
    JButton eight=new JButton("8");
    JButton nine=new JButton("9");
    JButton zero=new JButton("0");
    JButton plus=new JButton("+");
    JButton minus=new JButton("-");
    JButton divide=new JButton("/");
    JButton mult=new JButton("*");
    JButton per=new JButton("%");
    JButton dot=new JButton(".");
    JButton equal=new JButton("=");
    JButton inverse=new JButton("1/x");
    JButton clear=new JButton("C");
    JButton percent=new JButton("%");
    JButton sine=new JButton("sin");
    JButton cosine=new JButton("cos");
    JButton tangent=new JButton("tan");
    JButton sqrtn=new JButton("\u221A");
    JButton cqrtn=new JButton("\u221B");
    JButton sqrn=new JButton("x\u00B2");
    JButton fact=new JButton("x!");
    JButton pin=new JButton("\u03C0");
    JButton logn=new JButton("log");
    JButton en=new JButton("e");
    JButton abs=new JButton("abs");
    JButton mod=new JButton("mod");
    JButton exp=new JButton("exp");
    JButton pow=new JButton("^");
    boolean flag=false;
    double result=0;
    int track=0, fe=0, flag1=0, test=0;
    String str1="";

    public void initGUI(){
        super.setLayout(null);
        display.setBounds(8,10,246,50);
        display.setEditable(false);
    	display.setBackground(Color.decode("#000000"));
    	display.setForeground(Color.decode("#00CCCC"));
    	display.setFont(font1);
        super.add(display);
        display.setEditable(false);
        sine.setBounds(8,66,57,30);
        super.add(sine);
        cosine.setBounds(70,66,57,30);
        super.add(cosine);
        tangent.setBounds(132,66,57,30);
        super.add(tangent);
        logn.setBounds(194,66,59,30);
        super.add(logn);
        abs.setBounds(8,102,57,30);
        super.add(abs);
        inverse.setBounds(70,102,57,30);
        super.add(inverse);
        exp.setBounds(132,102,57,30);
        super.add(exp);
        mod.setBounds(194,102,59,30);
        super.add(mod);
        sqrtn.setBounds(8,138,45,30);
        super.add(sqrtn);
        cqrtn.setBounds(58,138,45,30);
        super.add(cqrtn);
        sqrn.setBounds(108,138,45,30);
        super.add(sqrn);
        pow.setBounds(158,138,45,30);
        super.add(pow);
        fact.setBounds(208,138,45,30);
        super.add(fact);
        seven.setBounds(8,174,45,30);
        super.add(seven);
        eight.setBounds(58,174,45,30);
        super.add(eight);
        nine.setBounds(108,174,45,30);
        super.add(nine);
        per.setBounds(158,174,45,30);
        super.add(per);
        clear.setBounds(208,174,45,30);
        super.add(clear);
        four.setBounds(8,210,45,30);
        super.add(four);
        five.setBounds(58,210,45,30);
        super.add(five);
        six.setBounds(108,210,45,30);
        super.add(six);
        mult.setBounds(158,210,45,30);
        super.add(mult);
        divide.setBounds(208,210,45,30);
        super.add(divide);
        one.setBounds(8,246,45,30);
        super.add(one);
        two.setBounds(58,246,45,30);
        super.add(two);
        three.setBounds(108,246,45,30);
        super.add(three);
        plus.setBounds(158,246,45,30);
        super.add(plus);
        minus.setBounds(208,246,45,30);
        super.add(minus);
        zero.setBounds(8,282,45,30);
        super.add(zero);
        dot.setBounds(58,282,45,30);
        super.add(dot);
        pin.setBounds(108,282,45,30);
        super.add(pin);
        en.setBounds(158,282,45,30);
        super.add(en);
        equal.setBounds(208,282,45,30);
        super.add(equal);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        zero.addActionListener(this);
        sine.addActionListener(this);
        cosine.addActionListener(this);
        tangent.addActionListener(this);
        abs.addActionListener(this);
        sqrtn.addActionListener(this);
        en.addActionListener(this);
        logn.addActionListener(this);
        pow.addActionListener(this);
        inverse.addActionListener(this);
        pin.addActionListener(this);
        dot.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        mult.addActionListener(this);
        divide.addActionListener(this);
        equal.addActionListener(this);
        per.addActionListener(this);
        clear.addActionListener(this);
        cqrtn.addActionListener(this);
        mod.addActionListener(this);
        exp.addActionListener(this);
        sqrn.addActionListener(this);
        fact.addActionListener(this);
    }
    
    public void sct(double val, String str){    //sct  -->  sin,cos,tan
        str=String.format("%.15f",val);
        display.setText(str);
        fe=1;
    }
    
    public void setNum(String n){
        String a=display.getText();
        if(fe==1){
            display.setText("");
            fe=0;
        }
        if(a.equals("0") && n!="."){
            display.setText(n);
        }
        else{
            display.setText(display.getText()+n);
        }
        test=0;
    }

    public void calcOperator(int n){
        if(flag1==0){
            flag1=1;
            result=Double.parseDouble(display.getText());
        }
        else{
            if(track==1){
                result+=Double.parseDouble(display.getText());
            }
            else if(track==2){
                result-=Double.parseDouble(display.getText());
            }
            else if(track==3){
                result*=Double.parseDouble(display.getText());
            }
            else if(track==4){
                result/=Double.parseDouble(display.getText());
            }
            else if(track==5){
                result%=Double.parseDouble(display.getText());
            }
            else if(track==6){
                result=Math.pow(result,Double.parseDouble(display.getText()));
            }
            display.setText(String.valueOf(result));
        }
        fe=1;
        track=n;
        test=1;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String str=display.getText();
        if(str.equals("INVALID INPUT") || str.equals("OVERFLOW")){
            if(e.getSource()==clear){
                display.setText("0");
            }
        }
        else{
            try{
                double val=Double.parseDouble(str);
                if(e.getSource()==sine){
                    sct(Math.sin(Math.toRadians(val)),str);
                }
                else if(e.getSource()==cosine){
                    sct(Math.cos(Math.toRadians(val)),str);
                }
                else if(e.getSource()==tangent){
                    sct(Math.tan(Math.toRadians(val)),str);
                }
                else if(e.getSource()==logn){
                    if(val<=0){
                        display.setText("INVALID INPUT");
                    }
                    else{
                        val=Math.log10(val);
                        str=val+"";
                        display.setText(str);
                    }
                    fe=1;
                }
                else if(e.getSource()==abs){
                    val=Math.abs(val);
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==inverse){
                    val=1.0/val;
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==exp){
                    val=Math.exp(val);
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==sqrtn){
                    val=Math.sqrt(val);
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==cqrtn){
                    val=Math.cbrt(val);
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==sqrn){
                    val=val*val;
                    str=val+"";
                    display.setText(str);
                    fe=1;
                }
                else if(e.getSource()==fact){
                    int x=(int)val;
                    if(x>=0 && x==val){
                        BigInteger res=new BigInteger("1");
                        for(int i=2;i<=x;i++){
                            res=res.multiply(BigInteger.valueOf(i));
                        }
                        str=res.doubleValue()+"";
                        if(!str.equals("Infinity"))
                            display.setText(res.doubleValue()+"");
                        else
                            display.setText("OVERFLOW");
                    }
                    else{
                        display.setText("INVALID INPUT");
                    }
                    fe=1;
                }
                else if(e.getSource()==clear){
                    display.setText("0");
                    result=fe=track=flag1=0;
                /*"track" for +,-,*,/,mod and pow ---  "flag1" - to check if it is the first input or not ---
                  "result" to keep the final result --- "fe" - to keep track if it is final result or not. 
                   if it is the final result then new input is not gonna add at the end of the result
                */
                }
                else if(e.getSource()==one){
                    setNum("1");
                }
                else if(e.getSource()==two){
                    setNum("2");
                }
                else if(e.getSource()==three){
                    setNum("3");
                }
                else if(e.getSource()==four){
                    setNum("4");
                }
                else if(e.getSource()==five){
                    setNum("5");
                }
                else if(e.getSource()==six){
                    setNum("6");
                }
                else if(e.getSource()==seven){
                    setNum("7");
                }
                else if(e.getSource()==eight){
                    setNum("8");
                }
                else if(e.getSource()==nine){
                    setNum("9");
                }
                else if(e.getSource()==zero){
                    setNum("0");
                }
                else if(e.getSource()==dot){
                    if(!str.contains(".")){
                        setNum(".");
                    }
                }
                else if(e.getSource()==plus && test==0){
                    calcOperator(1);
                }
                else if(e.getSource()==minus && test==0){
                    calcOperator(2);
                }
                else if(e.getSource()==mult && test==0){
                    calcOperator(3);
                }
                else if(e.getSource()==divide && test==0){
                    calcOperator(4);
                }
                else if(e.getSource()==mod && test==0){
                    calcOperator(5);
                }
                else if(e.getSource()==pow){
                    calcOperator(6);
                }
                else if(e.getSource()==per){
                    val=result*(val/100.0);
                    display.setText(val+"");
                }
                else if(e.getSource()==pin){
                    setNum(String.valueOf(Math.PI));
                }
                else if(e.getSource()==en){
                    setNum(String.valueOf(Math.E));
                }
                else if(e.getSource()==equal){
                    fe=1;
                    if(track==1){
                        result+=val;
                        display.setText(result+"");
                    }
                    else if(track==2){
                        result-=val;
                        display.setText(result+"");
                    }
                    else if(track==3){
                        result*=val;
                        display.setText(result+"");
                    }
                    else if(track==4){
                        result/=val;
                        display.setText(result+"");
                    }
                    else if(track==5){
                        result%=val;
                        display.setText(result+"");
                    }
                    else if(track==6){
                        result=Math.pow(result,val);
                        display.setText(result+"");
                    }
                    result=track=flag1=0;
                    fe=1;
                }
            }
            catch(Exception ex){
                if(!display.getText().equals("OVERFLOW"))
                    display.setText("INVALID INPUT");
            }
        }
    }

    void getIconImage(String cUsersIslamDesktopProcalc_iconpng){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
