package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(4,4));
        this.setSize(900,700);
        this.setResizable(false);
        this.setTitle("Air Traffic Control");
        this.setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel(new BorderLayout());
        panel3.setLayout(null);

        panel1.setBackground(new Color(57,75,85,255));
        panel2.setBackground(new Color(66,88,112));
        panel3.setBackground(new Color(84,108,120,255));
        panel4.setBackground(new Color(57,75,85,255));

        panel1.setPreferredSize(new Dimension(900,60));
        panel2.setPreferredSize(new Dimension(600,600));
        panel3.setPreferredSize(new Dimension(300,600));
        panel4.setPreferredSize(new Dimension(900,40));


        JLabel label1 = new JLabel();
        label1.setText("AIR TRAFFIC CONTROL");
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV Boli", Font.BOLD, 30));


        JLabel label2 = new JLabel(new ImageIcon("/Users/janrydzewski/Desktop/PROGRAM GLOWNY/src/Swing/grid.png"));


        JLabel label3 = new JLabel();
        label3.setText("Authors: J.Rydzewski, R.Sienkiewicz, A.Stefanowski    ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.PLAIN, 13));

        String[] cars = {"audi", "bmw", "mercedes", "hyundai"};

        JComboBox comboBox = new JComboBox(cars);
        comboBox.setFont(new Font("MV Boli", Font.PLAIN, 13));

        comboBox.setBounds(70,30,160,50);

        JLabel label4 = new JLabel("123");
        label4.setPreferredSize(new Dimension(200,500));
        label4.setBackground(new Color(57,75,85,255));
        label4.setOpaque(true);

        label4.setBounds(30,140,240,350);

        panel1.add(label1);
        panel2.add(label2);
        panel4.add(label3, BorderLayout.LINE_END);
        panel3.add(comboBox);
        panel3.add(label4);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);


        this.setVisible(true);
        System.out.println(panel1.getSize());
        System.out.println(panel2.getSize());
        System.out.println(panel3.getSize());
        System.out.println(panel4.getSize());
        System.out.println(comboBox.getSize());
        System.out.println(label4.getSize());
    }
}
