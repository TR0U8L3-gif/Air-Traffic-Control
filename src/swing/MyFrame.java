package swing;

import staticObjects.*;
import radar.*;
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
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    Radar radar;
    public JPanel panel2;
    JLabel label2;
    JPanel panel4;
    JTextField textField;

    public MyFrame(Radar radar) {

        this.radar = radar;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(4,4));
        this.setSize(900,700);
        this.setResizable(false);
        this.setTitle("Air Traffic Control");
        this.setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel4 = new JPanel();
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);

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


        label2 = new JLabel(new ImageIcon("src/swing/grid.png"));
        label2.setBounds(0,0,600,600);

        JLabel label3 = new JLabel();
        label3.setText("Authors: J.Rydzewski, R.Sienkiewicz, A.Stefanowski");
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label3.setBounds(550,0,400,30);

        textField = new JTextField("  TIME");
        textField.setBounds(50,0,150,40);
        panel4.add(textField);

        //String[] cars = {"audi", "bmw", "mercedes", "hyundai"};

        comboBox = new JComboBox(radar.ships.toArray());
        comboBox.insertItemAt("SELECT AIRSHIP", 0);
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("MV Boli", Font.PLAIN, 13));
        comboBox.addActionListener(this);
        comboBox.setBounds(30,30,250,25);

        JLabel label4 = new JLabel();
        label4.setLayout(null);

        label4a = new JLabel("FROM: ---------");
        label4b = new JLabel("TO: ---------");
        label4c = new JLabel("HEIGHT: ---------");
        label4d = new JLabel("SPEED: ---------");
        label4e = new JLabel("PROGRESS BAR: ");

        progressBar = new JProgressBar();
        progressBar.setValue(30);
        progressBar.setBounds(20,270,200,25);
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
        label4.setBounds(30,75,240,350);

        label4.add(label4a);
        label4.add(label4b);
        label4.add(label4c);
        label4.add(label4d);
        label4.add(label4e);
        label4.add(progressBar);

        button1 = new JButton("ADD OBJECT");
        button2 = new JButton("REMOVE OBJECT");

        button1.setBounds(25, 500,120,50);
        button2.setBounds(160, 500,120,50);

        button1.addActionListener(this);
        button2.addActionListener(this);

        button3 = new JButton("ADD AIRSHIP");
        button4 = new JButton("REMOVE AIRSHIP");

        button3.setBounds(25, 440,120,50);
        button4.setBounds(160, 440,120,50);

        button3.addActionListener(this);
        button4.addActionListener(this);

        panel1.add(label1);
        panel4.add(label3);
        panel3.add(comboBox);
        panel3.add(label4);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(button4);


        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);

        updateStaticObjects();
    }
    public void updateStaticObjects()
    {
        panel2.removeAll();
        for (int i =0; i <radar.staticObjects.size(); i++ )
        {
            if (radar.staticObjects.get(i).getType().equals("tree")){
                JLabel label = new JLabel(new ImageIcon("src/swing/treeicon.png"));
                label.setBounds(radar.staticObjects.get(i).getX(), radar.staticObjects.get(i).getY(), 2* (int)radar.staticObjects.get(i).getRadius(),2* (int)radar.staticObjects.get(i).getRadius());
                panel2.add(label);
            }

            else if(radar.staticObjects.get(i).getType().equals("building")){
                JLabel label = new JLabel(new ImageIcon("src/swing/buildingicon.png"));
                label.setBounds(radar.staticObjects.get(i).getX(), radar.staticObjects.get(i).getY(),2* (int)radar.staticObjects.get(i).getRadius(), 2* (int)radar.staticObjects.get(i).getRadius());
                panel2.add(label);
            }
        }
        for (int i =0; i <radar.ships.size(); i++ )
        {
            if (radar.ships.get(i).getName().equals("AirShip")){
                JLabel label = new JLabel(new ImageIcon("src/swing/ufo.png"));
                label.setBounds((int)radar.ships.get(i).getX(), (int)radar.ships.get(i).getY(), 3* (int)radar.ships.get(i).getRadius(),3* (int)radar.ships.get(i).getRadius());
                panel2.add(label);
            }

            else if (radar.ships.get(i).getName().equals("Balloon")){
                JLabel label = new JLabel(new ImageIcon("src/swing/balloon.png"));
                label.setBounds((int)radar.ships.get(i).getX(), (int)radar.ships.get(i).getY(),3* (int)radar.ships.get(i).getRadius(),3*(int)radar.ships.get(i).getRadius());
                panel2.add(label);
            }
            else if (radar.ships.get(i).getName().equals("Helicopter")){
                JLabel label = new JLabel(new ImageIcon("src/swing/helicopter.png"));
                label.setBounds((int)radar.ships.get(i).getX(), (int)radar.ships.get(i).getY(), 3*(int)radar.ships.get(i).getRadius(),3*(int)radar.ships.get(i).getRadius());
                panel2.add(label);
            }
            else if (radar.ships.get(i).getName().equals("Plane")){
                JLabel label = new JLabel(new ImageIcon("src/swing/plane.png"));
                label.setBounds((int)radar.ships.get(i).getX(), (int)radar.ships.get(i).getY(),3* (int)radar.ships.get(i).getRadius(),3*(int)radar.ships.get(i).getRadius());
                panel2.add(label);
            }
        }



        panel2.add(label2);
        panel2.revalidate();
        panel2.repaint();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
                label4a.setText("FROM: ---------");
                label4b.setText("TO: ---------");
                label4c.setText("HEIGHT: ---------");
                label4d.setText("SPEED: ---------");
                label4e.setText("PROGRESS BAR: ");
                progressBar.setValue(30);
        }
        if(e.getSource()==button1){
            String newData = JOptionPane.showInputDialog(" tree/building x y height hitbox\n example: tree 10 10 300 15");
            String[] newDataArray = newData.split(" ");
            if(newDataArray[0].equals("tree")){
                radar.addTree(new Tree(Integer.parseInt(newDataArray[1]), Integer.parseInt(newDataArray[2]), Integer.parseInt(newDataArray[3]), Integer.parseInt(newDataArray[4])));
            }

            else if(newDataArray[0].equals("building")){
                radar.addBuilding(new Building(Integer.parseInt(newDataArray[1]), Integer.parseInt(newDataArray[2]), Integer.parseInt(newDataArray[3]), Integer.parseInt(newDataArray[4])));
            }
            radar.showStaticObjects();
            updateStaticObjects();
        }
        if(e.getSource()==button2){
            String someText = radar.showStaticObjects();
            String index = JOptionPane.showInputDialog(someText);
            //System.out.println(index);
            radar.removeStaticObject(Integer.parseInt(index)-1);
            updateStaticObjects();

        }
    }
}
