package swing;

import figure.Cylinder;
import staticObjects.Building;
import staticObjects.StaticObject;
import staticObjects.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadObjectsFromFile {
    public static List<StaticObject> readStaticObjects(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        List<StaticObject> staticObjects = new ArrayList<>();

        while (input.hasNext()) {
            String type = input.next();
            double R = Double.parseDouble(input.next());
            double H = Double.parseDouble(input.next());
            //Cylinder hitbox = new Cylinder(R, H);
            int x = Integer.parseInt(input.next());
            int y = Integer.parseInt(input.next());

            switch (type) {
                case "B":
                    Building B =  new Building(x, y, R, H);
                    staticObjects.add(B);
                    break;
                case "T":
                    Tree T =  new Tree(x, y, R, H);
                    staticObjects.add(T);
                    break;
            }
        }
    return staticObjects;
    }
}
