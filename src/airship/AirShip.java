package airship;

import figure.*;
import distance.*;

public class AirShip {
    protected String name = "AirShip";
    protected Cylinder hitbox;
    public Path airPath;
    protected int startTime;
    protected double currentHeight;
    protected double currentSpeed;
    protected double x;
    protected double y;

    public AirShip(Cylinder hitbox, Path airPath) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = 0;
        move(0);
    }
    public AirShip(Cylinder hitbox, Path airPath, int startTime) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = startTime;
        move(0);
    }
    public double getCurrentHeight() { return this.currentHeight; }
    public double getCurrentSpeed() { return this.currentSpeed; }
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getHeight() { return this.hitbox.getH(); }
    public double getRadius() { return this.hitbox.getR(); }
    public double getFlightHeight() { return 0; }
    public double getFlightSpeed() { return 0; }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public void move(double time)
    {
        if (time <= startTime)
        {
            this.x = airPath.flightPath.get(0).getStartPoint().getX();
            this.y = airPath.flightPath.get(0).getStartPoint().getY();
            if(time == startTime)
            {
                this.currentHeight = airPath.flightPath.get(0).getHeight();
                this.currentSpeed = airPath.flightPath.get(0).getSpeed();
            }
            else
            {
                this.currentSpeed = 0;
                this.currentHeight = 0;
            }
        }
        else
        {
            double remainingTime = time - this.startTime;
            int pathIndex = 0;
            do
            {
                Point start = airPath.flightPath.get(pathIndex).getStartPoint();
                Point end = airPath.flightPath.get(pathIndex).getEndPoint();
                double speed = airPath.flightPath.get(pathIndex).getSpeed();
                double distance = Math.sqrt(Math.pow(end.getY() - start.getY(), 2) + Math.pow(end.getX() - start.getX(), 2));
                double pathTime = distance / speed;
                System.out.println( this.name + " Path index: [" + pathIndex + "/" + (airPath.flightPath.size()-1)+ "] speed: " + speed + " distance: " + distance + " time: " + pathTime);
                if(remainingTime - pathTime <= 0)
                {
                    double distanceToTravel = speed * remainingTime;
                    //line equation y=ax+b
                    double a = (end.getY() - start.getY())/(end.getX() - start.getX());
                    double b = start.getY() - (a * start.getX());
                    //circle equation (x-Sx)^2 + (y-Sy)^2 = r^2
                    double x1;
                    double x2;
                    // math is hard :(
                    this.x = 0;
                    this.y = 0;
                    this.currentHeight = airPath.flightPath.get(pathIndex).getHeight();
                    this.currentSpeed = airPath.flightPath.get(pathIndex).getSpeed();
                    break;
                }
                else
                {
                    pathIndex++;
                    if(pathIndex > (airPath.flightPath.size() - 1))
                    {
                        this.x = airPath.flightPath.get(airPath.flightPath.size() - 1).getEndPoint().getX();
                        this.y = airPath.flightPath.get(airPath.flightPath.size() - 1).getEndPoint().getY();
                        this.currentHeight = airPath.flightPath.get(airPath.flightPath.size() - 1).getHeight();
                        this.currentSpeed = airPath.flightPath.get(airPath.flightPath.size() - 1).getSpeed();
                        break;
                    }
                }

            }
            while (true);
        }
    }
    public String toString(){ return this.name + " (" + x + ", " + y + ")  h:" + this.hitbox.getH() + ", r:" + this.hitbox.getR() + ", start time: " + this.startTime; }
}
