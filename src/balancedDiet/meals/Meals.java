package balancedDiet.meals;

import balancedDiet.Author;
import balancedDiet.Person;
import balancedDiet.gui.CalorieIntake;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name = "Ankit Sharma", date = "22/June/2019")
public class Meals {
    private JFrame frame;
    private JPanel panel;
    private BufferedImage a, b, c, d;
    private JLabel q, r, s, t, category, bmi;
    private JButton button;

    public Meals(){
        try {
            prepareFrame();
        }
        catch (IOException h){
            h.printStackTrace();
        }
    }

    private void prepareFrame() throws IOException {
        frame = new JFrame();
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(null);

        button = new JButton("Daily-Intake");
        button.setSize(100, 50);

        a = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\food.jpg"));
        b = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\bfast.jpg"));
        c = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\lunch.png"));
        d = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\dinner.jpg"));

        q = new JLabel(new ImageIcon(a));
        r = new JLabel(new ImageIcon(b));
        s = new JLabel(new ImageIcon(c));
        t = new JLabel(new ImageIcon(d));
        Person p = new Person().getPerson();

        category = new JLabel(p.getCategory().getName());
        bmi = new JLabel("BMI is " + Math.round(p.getCategory().getBmiIndex()));

        Font font = new Font("Comic Sans", Font.BOLD, 18);
        category.setFont(font);
        bmi.setFont(font);

        r.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String breakFast = p.suggestBreakfast().getName();
                    String calories = String.valueOf(p.suggestBreakfast().getCalories());
                    String proteins = String.valueOf(p.suggestBreakfast().getProteins());
                    String carbs = String.valueOf(p.suggestBreakfast().getCarbs());
                    String fats = String.valueOf(p.suggestBreakfast().getFats());
                    String fibers = String.valueOf(p.suggestBreakfast().getFibers());
                    new Breakfast(breakFast, calories, carbs, proteins, fats, fibers);
                }
                catch (IOException h){
                    h.printStackTrace();
                }
            }
        });

        s.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String lunch = p.suggestLunch().getName();
                    String calories = String.valueOf(p.suggestLunch().getCalories());
                    String proteins = String.valueOf(p.suggestLunch().getProteins());
                    String carbs = String.valueOf(p.suggestLunch().getCarbs());
                    String fats = String.valueOf(p.suggestLunch().getFats());
                    String fibers = String.valueOf(p.suggestLunch().getFibers());
                    new Lunch(lunch, calories, carbs, proteins, fats, fibers);
                }
                catch (IOException h){
                    h.printStackTrace();
                }
            }
        });

        t.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String dinner = p.suggestDinner().getName();
                    String calories = String.valueOf(p.suggestDinner().getCalories());
                    String proteins = String.valueOf(p.suggestDinner().getProteins());
                    String carbs = String.valueOf(p.suggestDinner().getCarbs());
                    String fats = String.valueOf(p.suggestDinner().getFats());
                    String fibers = String.valueOf(p.suggestDinner().getFibers());
                    new Dinner(dinner, calories, carbs, proteins, fats, fibers);
                }
                catch (IOException h){
                    h.printStackTrace();
                }
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{new CalorieIntake();}
                catch (IOException d){
                    d.printStackTrace();
                }
            }
        });

        q.setBounds(10, 0, 484, 300);
        category.setBounds(10, 350, 200, 18);
        bmi.setBounds(220, 350, 250, 18);
        button.setBounds(450, 330, 100, 40);
        r.setBounds(10, 420, 128, 129);
        s.setBounds(200, 420, 128, 125);
        t.setBounds(390, 420, 128, 128);

        panel.add(q);
        panel.add(r);
        panel.add(button);
        panel.add(category); panel.add(bmi);
        panel.add(t);
        panel.add(s);
        panel.setBackground(Color.WHITE);
        frame.add(panel);
        frame.setVisible(true);
    }
}
