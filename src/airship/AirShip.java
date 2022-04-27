package airship;

import figure.*;
import distance.*;

public class AirShip {
    protected Cylinder hitbox;
    protected Path airPath;
    protected double startTime;
    protected double x;
    protected double y;

    public AirShip(Cylinder hitbox, Path airPath, int startTime) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = startTime;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public void move(double time)
    {
        if (time <= startTime)
        {
            this.x = airPath.flightPath.get(0).getStartPoint().getX();
            this.y = airPath.flightPath.get(0).getStartPoint().getY();
        }
    }
}
