package balancedDiet.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View {
    private JPanel panel;
    private JFrame frame;
    private static BufferedImage a, b, c, d, e, f, g;
    public static JTextField heightText, weightText, ageText, nameText;
    private static JLabel q, r, s, t, u, v, w;

    View() {
        try{createFrame();}
        catch (IOException h){
            h.printStackTrace();
        }
    }
    private void createFrame() throws IOException{
        frame = new JFrame();
        frame.setSize(640,730);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\title.jpg"));
        b = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\health.jpg"));
        c = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\id.png"));
        d = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\height.png"));
        e = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\weight.png"));
        f = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\cake.png"));
        g = ImageIO.read(new File("D:\\BalancedDiet\\src\\resources\\images\\ok.png"));

        q = new JLabel(new ImageIcon(a));
        r = new JLabel(new ImageIcon(b));
        s = new JLabel(new ImageIcon(c));
        t = new JLabel(new ImageIcon(d));
        u = new JLabel(new ImageIcon(e));
        v = new JLabel(new ImageIcon(f));
        w = new JLabel(new ImageIcon(g));

        nameText = new JTextField("Enter name");
        heightText = new JTextField("Enter height");
        weightText = new JTextField("Enter weight");
        ageText = new JTextField("Enter age");

        q.setBounds(10,0,600,350);
        r.setBounds(10, 350, 600, 50);
        s.setBounds(50, 425, 64, 64);
        t.setBounds(50, 520, 64, 64);
        u.setBounds(320, 520, 64, 64);
        v.setBounds(320,425, 64, 64);
        w.setBounds(270, 620, 64, 64);

        w.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread(new MyAnotherThread()).start();
                frame.dispose();
            }
        });

        nameText.setBounds(135, 440, 130, 30);
        heightText.setBounds(135, 540, 130, 30);
        ageText.setBounds(420, 440, 130, 30);
        weightText.setBounds(420, 540, 130, 30);

        nameText.setFont(new Font("Arial", Font.BOLD, 15));
        heightText.setFont(new Font("Arial", Font.BOLD, 15));
        ageText.setFont(new Font("Arial", Font.BOLD, 15));
        weightText.setFont(new Font("Arial", Font.BOLD, 15));

        q.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(frame,"Hello user! I'm Balanced Diet!\nUse me and see what's good for you to eat");
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.add(u);
        panel.add(w);
        panel.add(v);
        panel.add(q);
        panel.add(t);
        panel.add(s);
        panel.add(nameText);
        panel.add(ageText);
        panel.add(weightText);
        panel.add(heightText);
        panel.add(r);
        panel.setLayout(null);
        panel.setBackground(Color.white);

        frame.add(panel);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new View();
    }
}
