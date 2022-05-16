package airship;

import figure.*;
import distance.*;

public class AirShip {
    protected String name = "AirShip";
    protected Cylinder hitbox;
    public Path airPath;
    protected double startTime;
    protected double flightTime;
    protected double currentHeight;
    protected double currentSpeed;
    protected double x;
    protected double y;

    public AirShip(Cylinder hitbox, Path airPath) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = 0;
        setFlightTime();
        move(0);
    }
    public AirShip(Cylinder hitbox, Path airPath, int startTime) {
        this.airPath = airPath;
        this.hitbox = hitbox;
        this.startTime = startTime;
        setFlightTime();
        move(0);
    }
    public double getStartTime(){return this.startTime;}
    public double getFlightTime() { return this.flightTime; }
    public void setFlightTime() {
        double time = 0;
        for (int i = 0; i < this.airPath.flightPath.size(); i++)
        {
            Point start = this.airPath.flightPath.get(i).getStartPoint();
            Point end = this.airPath.flightPath.get(i).getEndPoint();
            double speed = this.airPath.flightPath.get(i).getSpeed();
            double distance = Math.sqrt(Math.pow(end.getY() - start.getY(), 2) + Math.pow(end.getX() - start.getX(), 2));
            time += distance / speed;
        }
        this.flightTime = time;
    }
    public double getCurrentHeight() { return this.currentHeight; }
    public double getCurrentSpeed() { return this.currentSpeed; }
    public double getX() { return this.x; }
    public double getY() { return this.y; }
    public double getHeight() { return this.hitbox.getH(); }
    public double getRadius() { return this.hitbox.getR(); }
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public void move(double time)
    {
        System.out.println("=================================");
        System.out.println(this.getName());
        System.out.println("Start time: " + this.startTime);
        System.out.println("Flight time: " + this.flightTime);
        if (time <= this.startTime)
        {
            System.out.println("plane is waiting for take off");
            this.x = this.airPath.flightPath.get(0).getStartPoint().getX();
            this.y = this.airPath.flightPath.get(0).getStartPoint().getY();
            if(time == this.startTime)
            {
                this.currentHeight = this.airPath.flightPath.get(0).getHeight();
                this.currentSpeed = this.airPath.flightPath.get(0).getSpeed();
            }
            else
            {
                this.currentSpeed = 0;
                this.currentHeight = 0;
            }
        }
        else if (time >= this.flightTime + this.startTime)
        {
            System.out.println("plane has landed");
            this.x = this.airPath.flightPath.get(this.airPath.flightPath.size()-1).getEndPoint().getX();
            this.y = this.airPath.flightPath.get(this.airPath.flightPath.size()-1).getEndPoint().getY();
            if(time == this.flightTime + this.startTime)
            {
                this.currentHeight = this.airPath.flightPath.get(this.airPath.flightPath.size()-1).getHeight();
                this.currentSpeed = this.airPath.flightPath.get(this.airPath.flightPath.size()-1).getSpeed();
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
                Point start = this.airPath.flightPath.get(pathIndex).getStartPoint();
                Point end = this.airPath.flightPath.get(pathIndex).getEndPoint();
                double speed = this.airPath.flightPath.get(pathIndex).getSpeed();
                double distance = Math.sqrt(Math.pow(end.getY() - start.getY(), 2) + Math.pow(end.getX() - start.getX(), 2));
                double pathTime = distance / speed;
                System.out.println( this.name + " Path index: [" + pathIndex + "/" + (this.airPath.flightPath.size()-1)+ "] speed: " + speed + " distance of section: " + distance + " total time: " + pathTime);
                if(remainingTime - pathTime <= 0)
                {

                    System.out.println("remainingTime: " + remainingTime);
                    double r = speed * remainingTime;
                    System.out.println("distance to go: " + r);
                    if(start.getX() != end.getX())
                    {
                        //line equation y=ax+b
                        double a = (end.getY() - start.getY()) / (end.getX() - start.getX());
                        double b = start.getY() - (a * start.getX());
                        //System.out.println("line equation: y=" + a + "x+" + b);
                        //circle equation (x-Sx)^2 + (y-Sy)^2 = r^2
                        double p = start.getX();
                        double q = start.getY();
                        System.out.println("start point: " + p + " " + q + " end point: " + end.getX() + " " + end.getY());
                        double sqrt = Math.sqrt((-1 * a * a * p * p) + (a * a * r * r) - (2 * a * b * p) + (2 * a * p * q) - (b * b) + (2 * b * q) - (q * q) + (r * r));
                        double v = (-1 * a * b) + (a * q) + p;
                        double x1 = (-1 * sqrt + v) / ((a * a) + 1);
                        double x2 = (sqrt + v) / ((a * a) + 1);
                        System.out.println("x1: " + x1 + " x2: " + x2);
                        // math is hard :(
                        //i feel your pain :C
                        if (airPath.flightPath.get(pathIndex).getDirection())
                        {
                            this.x = x2;
                        } else {
                            this.x = x1;
                        }
                        this.y = a * this.x + b;
                    }
                    else
                    {
                        //line equation x=ay+b
                        double a = (end.getX() - start.getX()) / (end.getY() - start.getY());
                        double b = start.getX() - (a * start.getY());
                        //System.out.println("line equation: x=" + a + "y+" + b);
                        //circle equation (x-Sx)^2 + (y-Sy)^2 = r^2
                        double p = start.getY();
                        double q = start.getX();
                        System.out.println("start point: " + p + " " + q + " end point: " + end.getX() + " " + end.getY());
                        double sqrt = Math.sqrt((-1 * a * a * p * p) + (a * a * r * r) - (2 * a * b * p) + (2 * a * p * q) - (b * b) + (2 * b * q) - (q * q) + (r * r));
                        double v = (-1 * a * b) + (a * q) + p;
                        double y1 = (-1 * sqrt + v) / ((a * a) + 1);
                        double y2 = (sqrt + v) / ((a * a) + 1);
                        System.out.println("y1: " + y1 + " y2: " + y2);
                        if (airPath.flightPath.get(pathIndex).getDirection())
                        {
                            this.y = y2;
                        } else {
                            this.y = y1;
                        }
                        this.x = a * this.y + b;
                    }
                    this.currentHeight = airPath.flightPath.get(pathIndex).getHeight();
                    this.currentSpeed = airPath.flightPath.get(pathIndex).getSpeed();
                    break;
                }
                else
                {
                    remainingTime -= pathTime;
                    pathIndex++;
                    if(pathIndex > (this.airPath.flightPath.size()-1))
                    {
                        System.out.println("Flight is over");
                        break;
                    }
                }
            }
            while (true);
        }
    }
    public String toString(){ return this.name +" [" + (airPath.flightPath.size())+ "] (" + (int)x + ", " + (int)y + ")"; }
}
