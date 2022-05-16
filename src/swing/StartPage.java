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

    JButton button;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JFileChooser fileChooser;
    JLabel label2;
    JLabel label3;

    Radar radar;

    public StartPage(Radar radar) {
        this.radar = radar;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 700);
        this.setResizable(false);
        this.setTitle("Air Traffic Control");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(84, 108, 120, 255));


        JLabel label = new JLabel("WELCOME TO THE AIR TRAFFIC CONTROL!");
        label.setBounds(100, 100, 700, 100);
        label.setFont(new Font("MV Boli", Font.BOLD, 30));
        label.setForeground(Color.white);

        button = new JButton("Continue");
        button.setBounds(300, 500, 300, 100);
        button.addActionListener(this);

        label2 = new JLabel("Selected: NONE");
        label2.setBounds(635, 250, 200, 75);
        label2.setFont(new Font("MV Boli", Font.BOLD, 15));
        label2.setForeground(Color.white);

        button2 = new JButton("Select map of Airships");
        button2.setBounds(80, 250, 250, 75);
        button2.addActionListener(this);

        label3 = new JLabel("Selected: NONE");
        label3.setBounds(635, 350, 200, 75);
        label3.setFont(new Font("MV Boli", Font.BOLD, 15));
        label3.setForeground(Color.white);

        button3 = new JButton("Select map of Static Objects");
        button3.setBounds(80, 350, 250, 75);
        button3.addActionListener(this);

        button4 = new JButton("Generate the map of Airships");
        button4.setBounds(355, 250, 250, 75);
        button4.addActionListener(this);

        button5 = new JButton("Generate the map of Static Objects");
        button5.setBounds(355, 350, 250, 75);
        button5.addActionListener(this);

        this.add(label);
        this.add(label2);
        this.add(button);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(label3);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            this.dispose();
            new MyFrame(this.radar);
        }
        if (e.getSource() == button2) {
            fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            label2.setText("SELECTED: " + file.getName());
            button4.setEnabled(false);
            try {
                java.util.List<AirShip> airShips = ReadShipsFromFile.readAirShips(file);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                // TODO: Wyswietlic komunikat o niepowodzeniu wczytywania pliku
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
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == button4) {
            //radar.renderShips();
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
    }
}
