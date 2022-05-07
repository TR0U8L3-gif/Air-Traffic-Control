package swing;

import airship.AirShip;
import radar.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class StartPage extends JFrame implements ActionListener {

    JButton button;
    JButton button2;
    JFileChooser fileChooser;
    JLabel label2;

    Radar radar;

        public StartPage(Radar radar){
            this.radar = radar;
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(900,700);
            this.setResizable(false);
            this.setTitle("Air Traffic Control");
            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.getContentPane().setBackground(new Color(84,108,120,255));


            JLabel label = new JLabel("WELCOME TO THE AIR TRAFFIC CONTROL!");
            label.setBounds(100,100,700,100);
            label.setFont(new Font("MV Boli", Font.BOLD, 30));
            label.setForeground(Color.white);



            label2 = new JLabel("Selected: NONE");
            label2.setBounds(500,300,200,50);
            label2.setFont(new Font("MV Boli", Font.BOLD, 15));
            label2.setForeground(Color.white);

            button = new JButton("Continue");
            button.setBounds(300,500,300,100);
            button.addActionListener(this);

            button2 = new JButton("Select map");
            button2.setBounds(250,300,200,50);
            button2.addActionListener(this);


            this.add(label);
            this.add(label2);
            this.add(button);
            this.add(button2);


            this.setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button){
                this.dispose();
                new MyFrame(this.radar);
            }
            if (e.getSource() == button2){
                fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file = fileChooser.getSelectedFile();
                label2.setText("SELECTED: " + file.getName());
                try {
                    java.util.List<AirShip> airShips = ReadFromFile.readAirShips(file);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    // TODO: Wyswietlic komunikat o niepowodzeniu wczytywania pliku
                }
            }
    }
}
