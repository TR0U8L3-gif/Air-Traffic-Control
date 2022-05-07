package airship;

import figure.*;
import distance.*;

public class AirShip {
    protected String name = "AirShip";
    protected Cylinder hitbox;
    protected Path airPath;
    protected int startTime;
    protected String type;
    protected double x;
    protected double y;

    public AirShip(Cylinder hitbox, Path airPath) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = 0;
        move(this.startTime);
    }
    public AirShip(Cylinder hitbox, Path airPath, int startTime) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = startTime;
        move(this.startTime);
    }
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getHeight() { return this.hitbox.getH(); }
    public double getRadius() { return this.hitbox.getR(); }
    public double getFlightHeight() { return 0; }
    public double getFlightSpeed() { return 0; }
    public String getType() { return this.type; }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() { return this.name; }
    public void setName(String name) {
        this.name = name;
    }

    public void move(double time)
    {
        if (time <= startTime)
        {
            this.x = airPath.flightPath.get(0).getStartPoint().getX();
            this.y = airPath.flightPath.get(0).getStartPoint().getY();
        }
        else
        {

        }
    }
    public String toString(){ return this.name + " (" + x + ", " + y + ")  h:" + this.hitbox.getH() + ", r:" + this.hitbox.getR(); }
}
