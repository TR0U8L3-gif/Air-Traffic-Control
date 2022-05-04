package staticObjects;

import figure.Cylinder;
import java.util.Random;

public class Tree extends StaticObject {
    public Tree()
    {
        Random rand = new Random();
        int upperbound = 100;

        this.type = "tree";
        /*
        this.x = rand.nextInt(upperbound)-50;
        this.y = rand.nextInt(upperbound)-50;

         */
        this.x = 50 + (int)(Math.random() * 550);
        this.y = 50 + (int)(Math.random() * 550);
        this.hitbox = new Cylinder(rand.nextInt(upperbound/5)+2, rand.nextInt(upperbound/2)+3);
    }
    public Tree(int x, int y, double r, double h) {
        this.type = "tree";
        this.x = x;
        this.y = y;
        this.hitbox = new Cylinder(r, h);
    }
    public Tree(Tree t) {
        this.type = "tree";
        this.x = t.x;
        this.y = t.y;
        this.hitbox = new Cylinder(t.hitbox.getR(), t.hitbox.getH());
    }
}