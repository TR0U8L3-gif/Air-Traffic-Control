package swing;

import airship.AirShip;
import radar.*;
import staticObjects.StaticObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class StartPage extends JFrame implements ActionListener {

    /*
    button - continue
    button2 - select map of airships
    button3 - select map of static objects
    button4 - generate map of airships
    button5 - generate map of static objects
    button6 - info about the map
    button7 - info about the static objects
     */

    JButton button, button2, button3, button4, button5, button6, button7;
    JLabel label, label2, label3;
    JFileChooser fileChooser;
    Radar radar;

    public StartPage(Radar radar) {

        //set values of StartPage

        this.radar = radar;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setResizable(false);
        this.setTitle("Air Traffic Control");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(84, 108, 120, 255));

        //create, set values of labels

        label = new JLabel("WELCOME TO THE AIR TRAFFIC CONTROL!");
        label.setBounds(100, 100, 700, 100);
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setForeground(Color.white);

        label2 = new JLabel("Selected: NONE");
        label2.setBounds(635, 250, 200, 75);
        label2.setFont(new Font("MV Boli", Font.BOLD, 15));
        label2.setForeground(Color.white);

        label3 = new JLabel("Selected: NONE");
        label3.setBounds(635, 350, 200, 75);
        label3.setFont(new Font("MV Boli", Font.BOLD, 15));
        label3.setForeground(Color.white);

        this.add(label);
        this.add(label2);
        this.add(label3);

        //create, set values of buttons

        button = new JButton("Continue");
        button.setBounds(300, 500, 300, 100);
        button.addActionListener(this);

        button2 = new JButton("Select map of Airships");
        button2.setBounds(80, 250, 250, 75);
        button2.addActionListener(this);

        button3 = new JButton("Select map of Static Objects");
        button3.setBounds(80, 350, 250, 75);
        button3.addActionListener(this);

        button4 = new JButton("Generate the map of Airships");
        button4.setBounds(355, 250, 250, 75);
        button4.addActionListener(this);

        button5 = new JButton("Generate the map of Static Objects");
        button5.setBounds(355, 350, 250, 75);
        button5.addActionListener(this);

        button6 = new JButton(new ImageIcon("src/swing/img/infoIcon.png"));
        button7 = new JButton(new ImageIcon("src/swing/img/infoIcon.png"));
        button6.setBounds(50, 260, 25, 25);
        button7.setBounds(50, 360, 25, 25);

        button6.setBorder(BorderFactory.createEmptyBorder());
        button6.setContentAreaFilled(false);

        button7.setBorder(BorderFactory.createEmptyBorder());
        button7.setContentAreaFilled(false);

        button6.addActionListener(this);
        button7.addActionListener(this);

        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);

        this.setVisible(true);
    }

    //interactive program

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            new MainPage(this.radar);
        }
        if (e.getSource() == button2) {
            fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            label2.setText("SELECTED: " + file.getName());
            button4.setEnabled(false);
            try {
                java.util.List<AirShip> airShips = ReadShipsFromFile.readAirShips(file);

                for(int i = 0; i < airShips.size(); i++){
                    radar.ships.add(airShips.get(i));
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("ERROR - UNABLE TO READ AIRSHIPS");
            }
        }
        if (e.getSource() == button3) {
            fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            label3.setText("SELECTED: " + file.getName());
            button5.setEnabled(false);
            try {
                java.util.List<StaticObject> staticObjects = ReadObjectsFromFile.readStaticObjects(file);

                for(int i = 0; i < staticObjects.size(); i++){
                    radar.staticObjects.add(staticObjects.get(i));
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println("ERROR - UNABLE TO READ STATIC OBJECTS");
            }
        }
        if (e.getSource() == button4) {
            radar.renderShips();
            button2.setEnabled(false);
            label2.setText("SELECTED: AUTO");
            radar.showShips();
        }
        if (e.getSource() == button5) {
            radar.renderStaticObjects();
            button3.setEnabled(false);
            label3.setText("SELECTED: AUTO");
            radar.showStaticObjects();
        }
        if (e.getSource() == button6) {
            JOptionPane.showMessageDialog(this, " type x0 y0 startTime radius height n x1 y1 s1 h1 ... xn yn sn hn\n example: \n H 200 300 10 30 0 30.0 40.0 10.0 20.0 40.0 50.0 3.0 20.0");
        }
        if (e.getSource() == button7) {
            JOptionPane.showMessageDialog(this, " type radius height x y\n example: \n T 30 30 100 100");
        }
    }
}
