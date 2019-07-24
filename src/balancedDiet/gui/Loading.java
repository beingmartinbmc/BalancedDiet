package balancedDiet.gui;

import javax.swing.*;

class Loading{
    static JFrame frame;
    static JPanel panel;
    static Icon b;
    static JLabel f;

    Loading(){
        frame=new JFrame();
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(2);
        panel=new JPanel();
        b= new ImageIcon("D:\\BalancedDiet\\src\\resources\\images\\loading.gif");
        f = new JLabel(b);
    }
}

