package staticObjects;

import figure.Cylinder;

public abstract class StaticObject
{
    protected Cylinder hitbox;
    protected int x;
    protected int y;
    protected String type;
    public String getType() {return this.type;}
    public double getHeight() { return hitbox.getH(); }
    public double getRadius() { return hitbox.getR(); }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public String toString()
    {
        return this.type + " x: " + this.x + " y: " + this.y + " " + hitbox.toString();
    }
}