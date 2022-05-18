package swing;

import airship.AirShip;
import airship.Balloon;
import airship.Helicopter;
import airship.Plane;
import distance.Path;
import distance.Point;
import distance.Section;
import figure.Cylinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class ReadShipsFromFile {
    public static List<AirShip> readAirShips(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<AirShip> airShips = new ArrayList<>();

        while (input.hasNext()) {
            String type = input.next();
            double x0 = Double.parseDouble(input.next());
            double y0 = Double.parseDouble(input.next());
            Point start = new Point(x0, y0);
            double R = Double.parseDouble(input.next());
            double H = Double.parseDouble(input.next());
            Cylinder hitbox = new Cylinder(R, H);
            Path path = new Path();

            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                double x = Double.parseDouble(input.next());
                double y = Double.parseDouble(input.next());
                String token = input.next();
                double s = Double.parseDouble(token);
                double h = Double.parseDouble(input.next());

                Point end = new Point(x, y);

                Section section = new Section(start, end);
                section.setSpeed(s);
                section.setHeight(h);
                path.addSection(section);

                start = end;
            }

            AirShip airShip;
            switch (type) {
                case "H":
                    airShip = new Helicopter(hitbox, path);
                    break;
                case "P":
                    airShip = new Plane(hitbox, path);
                    break;
                case "B":
                    airShip = new Balloon(hitbox, path);
                    break;
                default:
                    airShip = new AirShip(hitbox, new Path());
                    break;
            }
            airShips.add(airShip);
        }
        return airShips;
    }
}