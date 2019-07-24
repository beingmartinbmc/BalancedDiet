package balancedDiet.gui;

import balancedDiet.Author;
import balancedDiet.food.Food;
import balancedDiet.food.FoodItems;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Author(name = "Archit Gupta", date = "22/July/2019")

public class CalorieIntake {
    private JFrame frame;
    private JPanel panel;
    private	SpinnerModel fooditem1val,fooditem2val,liquidval;
    private JSpinner spinner1,spinner2,spinner3;
    private JComboBox fooditem1,fooditem2,liquid;
    private BufferedImage q,w,e,f;
    private JLabel a,s,d,back,go;
    private ImageIcon background;
    private Image img,temp;
    private JLabel qn1,qn2,qn3;
    int qty1,qty2,qty3;
    private Food food=new Food();
    private int total;

    public CalorieIntake() throws IOException {
        List<String> ls = new ArrayList<>();
        List<FoodItems> list=new ArrayList<>();

        list.add(null);
        ls.add("Select Items");

        for(int i=0;i<food.getAllItems().size();i++){
            FoodItems inputs = food.getAllItems().get(i);
            list.add(inputs);
            ls.add(inputs.getName());
        }
        String[] fooditems = ls.toArray(new String[ls.size()]);
        fooditem1val = new SpinnerNumberModel(1,1,10,1);
        fooditem2val = new SpinnerNumberModel(1,1,10,1);
        liquidval = new SpinnerNumberModel(1,1,10,1);

        spinner1=new JSpinner(fooditem1val);
        spinner2=new JSpinner(fooditem2val);
        spinner3=new JSpinner(liquidval);

        q=ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\b.jpg"));
        w=ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\l.png"));
        e=ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\d.jpg"));
        f=ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\checked.png"));

        qn1=new JLabel("Quantity:");
        qn2=new JLabel("Quantity:");
        qn3=new JLabel("Quantity:");

        go=new JLabel(new ImageIcon(f));
        a=new JLabel(new ImageIcon(q));
        s=new JLabel(new ImageIcon(w));
        d=new JLabel(new ImageIcon(e));

        fooditem1= new JComboBox(fooditems);
        fooditem2= new JComboBox(fooditems);
        liquid= new JComboBox(fooditems);

        background = new ImageIcon("D:\\BalancedDiet\\src\\resources\\images\\background.png");

        img = background.getImage();
        temp = img.getScaledInstance(640,300,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        back=new JLabel(background);

        back.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(frame,"Hello, You can calculate your calorie intake here.");
            }
        });

        back.setLayout(null);
        spinner1.setBounds(370,380,50,30);
        spinner2.setBounds(370,480,50,30);
        spinner3.setBounds(370,580,50,30);

        a.setBounds(30,360,80,80);
        s.setBounds(30,460,80,80);
        d.setBounds(30,560,80,80);

        qn1.setBounds(310,380,60,30);
        qn2.setBounds(310,480,60,30);
        qn3.setBounds(310,580,60,30);

        qn1.setFont(new Font("Arial", Font.BOLD, 13));
        qn2.setFont(new Font("Arial", Font.BOLD, 13));
        qn3.setFont(new Font("Arial", Font.BOLD, 13));

        back.setBounds(0,0,640,300);
        fooditem1.setBounds(150,380,130,30);
        fooditem2.setBounds(150,480,130,30);
        liquid.setBounds(150,580,130,30);

        go.setBounds(460,430,128,128);
        total=0;

        go.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                qty1=Integer.parseInt(spinner1.getValue().toString());
                qty2=Integer.parseInt(spinner2.getValue().toString());
                qty3=Integer.parseInt(spinner3.getValue().toString());
                if(fooditem1.getSelectedIndex()!=0) total+=(list.get(fooditem1.getSelectedIndex()).getCalories()*qty1);
                if(fooditem2.getSelectedIndex()!=0) total+=(list.get(fooditem2.getSelectedIndex()).getCalories()*qty2);
                if(liquid.getSelectedIndex()!=0) total+=(list.get(liquid.getSelectedIndex()).getCalories()*qty3);
                if(total>1000)  JOptionPane.showMessageDialog(frame,"Hello, Your total intake is "+total+" calories\nTry to cut on calories");
                else JOptionPane.showMessageDialog(frame,"Hello, Your total intake is "+total+" calories");
                total=0;
            }
        });

        panel = new JPanel();
        frame = new JFrame("Calorie Intake");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640,730);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        panel.add(qn1);panel.add(qn2);panel.add(qn3);
        panel.add(go);panel.add(a);
        panel.add(s);panel.add(d);
        panel.add(spinner1);panel.add(spinner2);
        panel.add(spinner3);panel.add(fooditem1);
        panel.add(fooditem2);panel.add(liquid);
        panel.add(back);panel.setLayout(null);
        frame.add(panel);
        frame.setVisible(true);
    }
}

