package objects.staticObjects;

import objects.flyingObjects.figure.Cylinder;
import java.util.Random;

public class Tree extends StaticObject {
    public Tree()
    {
        Random rand = new Random();
        int bound = 500;
        this.type = "tree";
        this.x = rand.nextInt(bound);
        this.y = rand.nextInt(bound);
        this.hitbox = new Cylinder(rand.nextInt(bound/30)+15, rand.nextInt(bound/20)+5);
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