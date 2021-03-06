package view.swing;

import objects.flyingObjects.airship.AirShip;
import objects.flyingObjects.airship.Balloon;
import objects.flyingObjects.airship.Helicopter;
import objects.flyingObjects.airship.Plane;
import objects.flyingObjects.distance.Path;
import objects.flyingObjects.distance.Point;
import objects.flyingObjects.distance.Section;
import objects.flyingObjects.figure.Cylinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class ReadShipsFromFile {
    public static List<AirShip> readAirShips(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<AirShip> airShips = new ArrayList<>();

        while (input.hasNext()) {
            String name = input.next();
            double x0 = Double.parseDouble(input.next());
            double y0 = Double.parseDouble(input.next());
            double startTime = Double.parseDouble(input.next());
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
            switch (name) {
                case "H":
                    airShip = new Helicopter(hitbox, path, startTime);
                    break;
                case "P":
                    airShip = new Plane(hitbox, path, startTime);
                    break;
                case "B":
                    airShip = new Balloon(hitbox, path, startTime);
                    break;
                default:
                    airShip = new AirShip(hitbox, new Path(), startTime);
                    break;
            }
            airShips.add(airShip);
        }
        return airShips;
    }
}