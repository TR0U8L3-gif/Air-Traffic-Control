package staticObjects;

import figure.Cylinder;

public abstract class StaticObject
{
    protected Cylinder hitbox;
    protected double x;
    protected double y;
    protected String type;

    public String toString()
    {
        return this.type + " x: " + this.x + " y: " + this.y + " " + hitbox.toString();
    }
}