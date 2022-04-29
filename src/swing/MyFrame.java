package swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JComboBox comboBox;
    JLabel label4a;
    JLabel label4b;
    JLabel label4c;
    JLabel label4d;
    JLabel label4e;
    JProgressBar progressBar;

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
        panel2.setLayout(null);
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
        label2.setBounds(0,0,600,600);

        JLabel label3 = new JLabel();
        label3.setText("Authors: J.Rydzewski, R.Sienkiewicz, A.Stefanowski    ");
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.PLAIN, 13));

        String[] cars = {"audi", "bmw", "mercedes", "hyundai"};

        comboBox = new JComboBox(cars);
        comboBox.setFont(new Font("MV Boli", Font.PLAIN, 13));
        comboBox.addActionListener(this);
        comboBox.setBounds(70,30,160,50);

        JLabel label4 = new JLabel();
        label4.setLayout(null);

        label4a = new JLabel("FROM: ---------");
        label4b = new JLabel("TO: ---------");
        label4c = new JLabel("HEIGHT: ---------");
        label4d = new JLabel("SPEED: ---------");
        label4e = new JLabel("PROGRESS BAR: ");

        progressBar = new JProgressBar();
        progressBar.setValue(30);
        progressBar.setBounds(20,260,200,50);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.white);

        label4a.setBounds(20,30,200,50);
        label4b.setBounds(20,80,200,50);
        label4c.setBounds(20,130,200,50);
        label4d.setBounds(20,180,200,50);
        label4e.setBounds(20,230,200,50);

        label4a.setForeground(Color.white);
        label4b.setForeground(Color.white);
        label4c.setForeground(Color.white);
        label4d.setForeground(Color.white);
        label4e.setForeground(Color.white);

        label4a.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label4b.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label4c.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label4d.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label4e.setFont(new Font("MV Boli", Font.PLAIN, 13));


        label4.setBackground(new Color(57,75,85,255));
        label4.setOpaque(true);
        label4.setBounds(30,140,240,350);

        label4.add(label4a);
        label4.add(label4b);
        label4.add(label4c);
        label4.add(label4d);
        label4.add(label4e);
        label4.add(progressBar);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            if(comboBox.getSelectedItem()=="bmw"){
                label4b.setText("TO: przeciez to nie jezdzi");
                label4c.setText("HEIGHT: 2m under the water");
                progressBar.setValue(0);
            }
            else{
                label4a.setText("FROM: ---------");
                label4b.setText("TO: ---------");
                label4c.setText("HEIGHT: ---------");
                label4d.setText("SPEED: ---------");
                label4e.setText("PROGRESS BAR: ");
                progressBar.setValue(30);
            }
        }
    }
}
