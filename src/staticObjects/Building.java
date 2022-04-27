package staticObjects;

import figure.Cylinder;
import java.util.Random;

public class Building extends StaticObject {
    public Building() {
        Random rand = new Random();
        int upperbound = 50;

        this.type = "building";
        this.x = rand.nextInt(upperbound)-25;
        this.y = rand.nextInt(upperbound)-25;
        this.hitbox = new Cylinder(rand.nextInt(upperbound/2)+10, rand.nextInt(upperbound*3)+5);
    }
    public Building(double x, double y, double r, double h) {
        this.type = "building";
        this.x = x;
        this.y = y;
        this.hitbox = new Cylinder(r, h);
    }
    public Building(Building b) {
        this.type = "building";
        this.x = b.x;
        this.y = b.y;
        this.hitbox = new Cylinder(b.hitbox.getR(), b.hitbox.getH());
    }
}