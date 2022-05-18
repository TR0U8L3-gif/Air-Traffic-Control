package swing;

import airship.AirShip;
import airship.Balloon;
import airship.Helicopter;
import airship.Plane;
import distance.Path;
import distance.Point;
import distance.Section;
import figure.Cylinder;
import staticObjects.*;
import radar.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class MyFrame extends JFrame implements ActionListener, ChangeListener {

    public static JLabel label3;
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
    JButton button5;
    JSlider slider;
    JButton button6;
    JButton button7;
    java.util.Timer timer;
    int delay;
    int period;
    boolean timerStart = false;
    int selectedItem;

    Radar radar;
    public JPanel panel2;
    public JPanel panel3;
    public JLabel label2;
    JPanel panel4;

    ArrayList<JLabel> labelList = new ArrayList<JLabel>();
    ArrayList<JLabel> pinList = new ArrayList<JLabel>();


    public MyFrame(Radar radar) {

        this.radar = radar;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(4,4));
        this.setSize(1000,700);
        this.setResizable(false);
        this.setTitle("Air Traffic Control");
        this.setLocationRelativeTo(null);

        JPanel panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();

        panel1.setLayout(null);
        panel2.setLayout(null);
        panel3.setLayout(null);
        panel4.setLayout(null);

        panel1.setBackground(new Color(57,75,85,255));
        panel2.setBackground(new Color(66,88,112));
        panel3.setBackground(new Color(84,108,120,255));
        panel4.setBackground(new Color(57,75,85,255));

        panel1.setPreferredSize(new Dimension(900,60));
        panel2.setPreferredSize(new Dimension(600,600));
        panel3.setPreferredSize(new Dimension(400,600));
        panel4.setPreferredSize(new Dimension(900,40));

        JLabel label1 = new JLabel();
        label1.setText("AIR TRAFFIC CONTROL");
        label1.setForeground(Color.white);
        label1.setFont(new Font("MV Boli", Font.BOLD, 30));
        label1.setBounds(350,0,500,50);

        label3 = new JLabel();
        label3.setText("TIME: " + String.format("%.2f", radar.time));
        label3.setBounds(50,0,200,50);
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.BOLD, 20));

        panel1.add(label3);

        button5 = new JButton("RESET");
        panel4.add(button5);
        button5.setBounds(10,6,80,25);
        button5.addActionListener(this);

        label2 = new JLabel(new ImageIcon("src/swing/img/grid.png"));
        label2.setBounds(0,0,600,600);

        JLabel label3 = new JLabel();
        label3.setText("Authors: J.Rydzewski, R.Sienkiewicz, A.Stefanowski");
        label3.setForeground(Color.white);
        label3.setFont(new Font("MV Boli", Font.PLAIN, 13));
        label3.setBounds(630,5,400,30);

        comboBox = new JComboBox(radar.ships.toArray());
        comboBox.insertItemAt("SELECT AIRSHIP", 0);
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("MV Boli", Font.PLAIN, 13));
        comboBox.addActionListener(this);
        comboBox.setBounds(30,30,250,25);
        System.out.println(comboBox.getItemCount());

        JLabel label4 = new JLabel();
        label4.setLayout(null);

        label4a = new JLabel("FROM:   ---------");
        label4b = new JLabel("TO:     ---------");
        label4c = new JLabel("HEIGHT: ---------");
        label4d = new JLabel("SPEED:  ---------");
        label4e = new JLabel("PROGRESS BAR: ");

        progressBar = new JProgressBar();
        progressBar.setValue(0);
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
        panel3.add(comboBox);
        panel3.add(label4);
        panel3.add(button1);
        panel3.add(button2);
        panel3.add(button3);
        panel3.add(button4);
        panel4.add(label3);
        int length = String.valueOf((int)radar.maxFlightTime()).length();
        System.out.println(radar.maxFlightTime() + " : " + length + " "+ Math.ceil(radar.maxFlightTime()/Math.pow(10,length-1)) * Math.pow(10,length-1));
        slider = new JSlider(0,(int)(Math.ceil(radar.maxFlightTime()/Math.pow(10,length-1)) * Math.pow(10,length-1)),0);
        this.add(slider);
        slider.setBounds(900,180,75,400);
        slider.setOrientation(SwingConstants.VERTICAL);
        slider.setMinorTickSpacing(100);
        slider.setMajorTickSpacing(100);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setPaintLabels(true);
        slider.setFont(new Font("MV Boli", Font.PLAIN, 13));
        slider.setForeground(Color.white);
        slider.addChangeListener(this);

        button6 = new JButton("START");
        button7 = new JButton("STOP");
        button6.setBounds(900,75,80,30);
        button7.setBounds(900,105,80,30);
        this.add(button6);
        this.add(button7);
        button7.addActionListener(this);
        button6.addActionListener(this);

        JLabel label = new JLabel("");
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label.setForeground(Color.white);
        label.setBounds(916,140, 80,26);
        this.add(label);

        updateMap();

        delay = 10;
        period = 40;
        timer = new Timer();
        timer();

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);

    }
    public void timer()
    {
        double count[] = {radar.getTime()};
        timer.scheduleAtFixedRate(new TimerTask()
        {
            public void run()
            {
                if(timerStart)
                {
                    count[0] = radar.getTime();
                    count[0]+= 0.25;
                    radar.setTime(count[0]);
                    MyFrame.label3.setText("TIME: " + Double.toString(radar.time));
                    for (int i = 0; i < radar.ships.size(); i++) {
                        radar.ships.get(i).move(radar.getTime());
                    }
                    slider.setValue((int)radar.getTime());
                    updateText();

                }
            }
        }, delay, period);
    }
    public void updateText(){
        if(selectedItem != 0) {
            pinList.clear();
            label4a.setText("FROM: X: " + radar.ships.get(selectedItem - 1).airPath.flightPath.get(0).getStartPoint().getX() + " Y: " + radar.ships.get(selectedItem - 1).airPath.flightPath.get(0).getStartPoint().getY());
            label4b.setText("TO: X: " + radar.ships.get(selectedItem - 1).airPath.flightPath.get(radar.ships.get(selectedItem - 1).airPath.flightPath.size() - 1).getEndPoint().getX() + " Y: " + radar.ships.get(selectedItem - 1).airPath.flightPath.get(radar.ships.get(selectedItem - 1).airPath.flightPath.size() - 1).getEndPoint().getY());
            label4c.setText("HEIGHT: " + radar.ships.get(selectedItem - 1).getCurrentHeight());
            label4d.setText("SPEED: " + radar.ships.get(selectedItem - 1).getCurrentSpeed());
            label4e.setText("PROGRESS BAR: ");
            double progress = ((radar.getTime()-radar.ships.get(selectedItem-1).getStartTime())/radar.ships.get(selectedItem-1).getFlightTime())*100;
            System.out.println(progress);
            if (progress <= 0) {
                progress = 0;
            }
            else if(progress>100){
                progress = 100;
            }
            progressBar.setValue((int)progress);

            for (int i = 0; i < radar.ships.get(selectedItem - 1).airPath.flightPath.size(); i++) {
                pinList.add(new JLabel(new ImageIcon("src/swing/img/redPin.png")));
                pinList.get(i).setBounds((int) radar.ships.get(selectedItem - 1).airPath.flightPath.get(i).getStartPoint().getX()-50, (int) radar.ships.get(selectedItem - 1).airPath.flightPath.get(i).getStartPoint().getY()-50, 30, 30);
                if (i == radar.ships.get(selectedItem - 1).airPath.flightPath.size() - 1) {
                    pinList.add(new JLabel(new ImageIcon("src/swing/img/redPin.png")));
                    pinList.get(i + 1).setBounds((int) radar.ships.get(selectedItem - 1).airPath.flightPath.get(i).getEndPoint().getX()-50, (int) radar.ships.get(selectedItem - 1).airPath.flightPath.get(i).getEndPoint().getY()-50, 30, 30);
                }
            }
        }
        else
        {
            label4a.setText("FROM:   ---------");
            label4b.setText("TO:     ---------");
            label4c.setText("HEIGHT: ---------");
            label4d.setText("SPEED:  ---------");
            label4e.setText("PROGRESS BAR: ");
            pinList.clear();
            progressBar.setValue(0);
        }
    }
    public void updateMap()
    {
        updateText();
        panel2.removeAll();

        for (int i =0; i <radar.ships.size(); i++ )
        {
            if (radar.ships.get(i).getName().equals("AirShip")){
                labelList.add(new JLabel(new ImageIcon("src/swing/img/ufo.png")));
                labelList.get(i).setBounds((int)radar.ships.get(i).getX()-50, (int)radar.ships.get(i).getY()-50, 3* (int)radar.ships.get(i).getRadius(),3* (int)radar.ships.get(i).getRadius());
                panel2.add(labelList.get(i));
            }
            else if (radar.ships.get(i).getName().equals("Balloon")){
                labelList.add(new JLabel(new ImageIcon("src/swing/img/balloon.png")));
                labelList.get(i).setBounds((int)radar.ships.get(i).getX()-50, (int)radar.ships.get(i).getY()-50, 3* (int)radar.ships.get(i).getRadius(),3* (int)radar.ships.get(i).getRadius());
                panel2.add(labelList.get(i));
            }
            else if (radar.ships.get(i).getName().equals("Helicopter")){
                labelList.add(new JLabel(new ImageIcon("src/swing/img/helicopter.png")));
                labelList.get(i).setBounds((int)radar.ships.get(i).getX()-50, (int)radar.ships.get(i).getY()-50, 3* (int)radar.ships.get(i).getRadius(),3* (int)radar.ships.get(i).getRadius());
                panel2.add(labelList.get(i));
            }
            else if (radar.ships.get(i).getName().equals("Plane")){
                labelList.add(new JLabel(new ImageIcon("src/swing/img/plane.png")));
                labelList.get(i).setBounds((int)radar.ships.get(i).getX()-50, (int)radar.ships.get(i).getY()-50, 3* (int)radar.ships.get(i).getRadius(),3* (int)radar.ships.get(i).getRadius());
                panel2.add(labelList.get(i));
            }
        }
        for (int i =0; i <radar.staticObjects.size(); i++ )
        {
            if (radar.staticObjects.get(i).getType().equals("tree")){
                JLabel label = new JLabel(new ImageIcon("src/swing/img/treeicon.png"));
                label.setBounds(radar.staticObjects.get(i).getX()-50, radar.staticObjects.get(i).getY()-50, 4* (int)radar.staticObjects.get(i).getRadius(),4* (int)radar.staticObjects.get(i).getRadius());
                panel2.add(label);
            }
            else if(radar.staticObjects.get(i).getType().equals("building")){
                JLabel label = new JLabel(new ImageIcon("src/swing/img/buildingicon.png"));
                label.setBounds(radar.staticObjects.get(i).getX()-50, radar.staticObjects.get(i).getY()-50,4* (int)radar.staticObjects.get(i).getRadius(), 4* (int)radar.staticObjects.get(i).getRadius());
                panel2.add(label);
            }
        }
        if(pinList.size()>0){
            for(int i=0; i < pinList.size(); i++){
                panel2.add(pinList.get(i));
            }
        }

        for(int i = 0; i < radar.ships.size(); i++){
            for(int k = 0; k < radar.staticObjects.size(); k++){
                if(radar.isSafeStaticObject(radar.ships.get(i), radar.staticObjects.get(k))){
                    continue;
                }
                else{
                    JOptionPane.showMessageDialog(this, "DANGER! " + radar.ships.get(i).getName() + " " + radar.ships.get(i).getX() + " " + radar.ships.get(i).getY() + " " + radar.ships.get(i).getCurrentHeight() + " collides with " + radar.staticObjects.get(k).getType()+ " " + radar.staticObjects.get(k).getX() + " " + radar.staticObjects.get(k).getY() + " " + radar.staticObjects.get(k).getHeight(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }


        for(int i = 0; i < radar.ships.size(); i++){
            for(int k = 0; k < radar.ships.size(); k++){
                if(radar.ships.get(i) != radar.ships.get(k)){
                    if(radar.isSafeAirShip(radar.ships.get(i), radar.ships.get(k))){
                        continue;
                    }
                    else{
                        JOptionPane.showMessageDialog(this, "DANGER! " + radar.ships.get(i).getName() + " " + radar.ships.get(i).getX() + " " + radar.ships.get(i).getY() + " " + radar.ships.get(i).getCurrentHeight() + " collides with " + radar.ships.get(k).getName()+ " " + radar.ships.get(k).getX() + " " + radar.ships.get(k).getY() + " " + radar.ships.get(k).getCurrentHeight(), "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }

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
            selectedItem = comboBox.getSelectedIndex();
            updateMap();
        }
        if(e.getSource()==button1){

            String newData = JOptionPane.showInputDialog(" tree/building x y radius height\n example: tree 100 150 30 15");
            String[] newDataArray = newData.split(" ");

            if(newDataArray[0].equals("tree")){
                radar.addTree(new Tree(Integer.parseInt(newDataArray[1]), Integer.parseInt(newDataArray[2]), Integer.parseInt(newDataArray[3]), Integer.parseInt(newDataArray[4])));
            }

            else if(newDataArray[0].equals("building")){
                radar.addBuilding(new Building(Integer.parseInt(newDataArray[1]), Integer.parseInt(newDataArray[2]), Integer.parseInt(newDataArray[3]), Integer.parseInt(newDataArray[4])));
            }
            radar.showStaticObjects();
            updateMap();
        }
        if(e.getSource()==button2){
            String someText = radar.showStaticObjects();
            String index = JOptionPane.showInputDialog(someText);
            radar.removeStaticObject(Integer.parseInt(index)-1);
            updateMap();

        }
        if(e.getSource()==button3){
            String newData = JOptionPane.showInputDialog("airship/plane/helicopter/balloon radius height x0 y0 n x1 y1 s1 h1 xn yn sn hn\n example: P 1.0 2.0 400 50 1 60.0 60.0 20.0 3.0");
            String[] newDataArray = newData.split(" ");
            double R = Double.parseDouble(newDataArray[1]);
            double H = Double.parseDouble(newDataArray[2]);
            Cylinder hitbox = new Cylinder(R, H);
            double x0 = Double.parseDouble(newDataArray[3]);
            double y0 = Double.parseDouble(newDataArray[4]);
            distance.Point start = new distance.Point(x0, y0);
            Path path = new Path();

            int n = Integer.parseInt(newDataArray[5]);
            for (int i = 0; i < n; i++) {
                double x = Double.parseDouble(newDataArray[5+i*1]);
                double y = Double.parseDouble(newDataArray[5+i*2]);
                double s = Double.parseDouble(newDataArray[5+i*3]);
                double h = Double.parseDouble(newDataArray[5+i*4]);

                distance.Point end = new Point(x, y);

                Section section = new Section(start, end);
                section.setSpeed(s);
                section.setHeight(h);
                path.addSection(section);

                start = end;
            }
            AirShip airShip;
            if(newDataArray[0].equals("H")){
                airShip = new Helicopter(hitbox, path);
                radar.ships.add(airShip);
            }
            else if(newDataArray[0].equals("P")){
                airShip = new Plane(hitbox, path);
                radar.ships.add(airShip);
            }
            else if(newDataArray[0].equals("B")){
                airShip = new Balloon(hitbox, path);
                radar.ships.add(airShip);
            }
            else{
                airShip = new AirShip(hitbox, path);
                radar.ships.add(airShip);
            }
            comboBox.insertItemAt(airShip, comboBox.getItemCount());
            int length = String.valueOf((int)radar.maxFlightTime()).length();
            System.out.println(radar.maxFlightTime() + " : " + length + " "+ Math.ceil(radar.maxFlightTime()/Math.pow(10,length-1)) * Math.pow(10,length-1));
            slider.setMaximum((int)(Math.ceil(radar.maxFlightTime()/Math.pow(10,length-1)) * Math.pow(10,length-1)));
            updateMap();
        }
        if(e.getSource()==button4){
            System.out.println(comboBox.getItemCount());
            String someText = radar.showShips();
            String index = JOptionPane.showInputDialog(someText);
            radar.removeAirShips(Integer.parseInt(index)-1);

            comboBox.removeItemAt(Integer.parseInt(index));
            updateMap();

        }
        if(e.getSource()==button5){
            this.dispose();
            radar.staticObjects.clear();
            radar.ships.clear();
            radar.setTime(0);
            new StartPage(radar);
        }
        if(e.getSource()==button7){
            timerStart = false;
            if(timerStart == false){
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(true);
                button4.setEnabled(true);
                button5.setEnabled(true);
                slider.setEnabled(true);

            }
        }
        if(e.getSource()==button6){
            timerStart = true;
            if(timerStart == true){
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                button5.setEnabled(false);
                slider.setEnabled(false);
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        radar.setTime(slider.getValue());
        MyFrame.label3.setText("TIME: " + Double.toString(radar.time));
        for (int i = 0; i < radar.ships.size(); i++) {
            radar.ships.get(i).move(radar.getTime());
        }
        updateMap();
        System.out.println(radar.getTime());
    }

}
