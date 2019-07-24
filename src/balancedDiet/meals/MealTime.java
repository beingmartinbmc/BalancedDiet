package balancedDiet.meals;

import balancedDiet.Author;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Author(name = "Pranjul Jani", date = "22/July/2019")
class MealTime {
    private JFrame frame;
    private JPanel panel;
    private ImageIcon background;
    private Image img,temp;
    private BufferedImage a, b, c, d, e, f;
    private JLabel back, q, r, s, t, u, v;
    private JLabel name, calories, proteins, fats, carbs, fibers;

    MealTime() {}

    void createFrame(String n, String cal, String carb, String pro, String fat, String fib) throws IOException {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(680, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel.setLayout(null);

        background=new ImageIcon("D:\\BalancedDiet\\src\\resources\\images\\homeworkbackground.jpg");
        img=background.getImage();
        temp=img.getScaledInstance(680,500, Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,680,500);
        
        name = new JLabel();
        calories = new JLabel();
        proteins = new JLabel();
        fats = new JLabel();
        carbs = new JLabel();
        fibers = new JLabel();

        a = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\menu.png"));
        b = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\burn.png"));
        c = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\meat.png"));
        d = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\pizza.png"));
        e = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\rice.png"));
        f = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\apple.png"));
        
        Font font = new Font("Arial", Font.BOLD, 15);
        name.setFont(font);
        calories.setFont(font);
        proteins.setFont(font);
        fats.setFont(font);
        carbs.setFont(font);
        fibers.setFont(font);

        name.setText(n); calories.setText(cal); carbs.setText(carb);
        proteins.setText(pro); fats.setText(fat); fibers.setText(fib);

        q = new JLabel(new ImageIcon(a));
        r = new JLabel(new ImageIcon(b));
        s = new JLabel(new ImageIcon(c));
        t = new JLabel(new ImageIcon(d));
        u = new JLabel(new ImageIcon(e));
        v = new JLabel(new ImageIcon(f));

        q.setBounds(40, 100, 32, 32);
        name.setBounds(100, 105, 550, 20);
        r.setBounds(40, 160, 32, 32);
        calories.setBounds(100, 165, 300, 15);
        s.setBounds(40, 220, 32, 32);
        proteins.setBounds(100, 225, 300, 15);
        t.setBounds(40, 280, 32, 32);
        fats.setBounds(100, 285, 300, 15);
        u.setBounds(40, 340, 32, 32);
        carbs.setBounds(100, 345, 300, 15);
        v.setBounds(40, 400, 32, 32);
        fibers.setBounds(100, 405, 300, 15);
        addToPanel();
        frame.add(panel);
        frame.setVisible(true);
    }

    private void addToPanel(){
        panel.add(q);
        panel.add(name);
        panel.add(u); panel.add(v);
        panel.add(carbs); panel.add(fibers);
        panel.add(fats); panel.add(proteins); panel.add(calories);
        panel.add(s);
        panel.add(r);
        panel.add(t);
        panel.add(back);
    }
}
