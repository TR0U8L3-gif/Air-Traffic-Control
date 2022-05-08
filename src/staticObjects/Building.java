package staticObjects;

import figure.Cylinder;
import java.util.Random;

public class Building extends StaticObject {
    public Building() {
        Random rand = new Random();
        int bound = 500;
        this.type = "building";
        this.x = rand.nextInt(bound);
        this.y = rand.nextInt(bound);
        this.hitbox = new Cylinder(rand.nextInt(bound/35)+15, rand.nextInt(bound/10)+15);
    }
    public Building(int x, int y, double r, double h) {
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