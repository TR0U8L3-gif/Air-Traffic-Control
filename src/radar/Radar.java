package radar;

import java.util.*;
import airship.*;
import distance.*;
import figure.Cylinder;
import staticObjects.*;
import swing.MyFrame;

import javax.swing.*;

public class Radar {
    public double time = 0;
    public List<StaticObject> staticObjects = new ArrayList<>();
    public List<AirShip> ships = new ArrayList<>();

    public void setTime(double time)
    {
        this.time = time;
    }
    public double getTime() { return this.time; }

    public int countStaticObjects() { return this.staticObjects.size(); }
    public String showStaticObjects()
    {
        String msg = "Static Objects: \n";
        System.out.println("static objects: ");
        for (int i =0; i <staticObjects.size(); i++ )
        {
            msg += (i+1)+") " + staticObjects.get(i).toString()+"\n";
            System.out.println(staticObjects.get(i));
            //System.out.println(staticObjects.get(i).getX());
            //System.out.println(staticObjects.get(i).getY());
        }
        return msg;
    }
    public void renderStaticObjects()
    {
        Random rand = new Random();
        for (int i = 0; i<=rand.nextInt(5)+1; i++)
        {
            if(rand.nextBoolean())
            {
                this.staticObjects.add(new Tree());
            }
            else
            {
                this.staticObjects.add(new Building());
            }
        }
    }
    public void renderStaticObjects(int x)
    {
        Random rand = new Random();
        for (int i = 0; i < x; i++)
        {
            if(rand.nextBoolean())
            {
                this.staticObjects.add(new Tree());
            }
            else
            {
                this.staticObjects.add(new Building());
            }
            System.out.println(staticObjects.get(i).toString());
        }
    }
    public void removeStaticObject(int index)
    {
        if(index>=0 && index<this.staticObjects.size())
            this.staticObjects.remove(index);
    }
    public void removeAirShips(int index)
    {
        if(index>=0 && index<this.ships.size())
            this.ships.remove(index);
    }
    public void clearStaticObjects() { this.staticObjects.clear(); }
    public void addTree(Tree tree){ this.staticObjects.add(tree); }
    public void addBuilding(Building build){ this.staticObjects.add(build); }
    public void removeTree(Tree tree)
    {
        try { this.staticObjects.remove(tree); }
        catch (Exception e) { throw new RuntimeException(e); }
    }
    public void removeBuilding(Building build)
    {
        try { this.staticObjects.remove(build); }
        catch (Exception e) { throw new RuntimeException(e); }
    }

    public int countShips() { return this.ships.size(); }
    public String showShips()
    {
        String msg = "Airships: \n";
        System.out.println("ships: ");
        for (int i =0; i <ships.size(); i++ )
        {
            msg += (i+1)+") " + ships.get(i).toString()+"\n";
            System.out.println(this.ships.get(i));
        }
        return msg;
    }

    public void renderShips()
    {
        int bound = 401;
        Random rand = new Random();
        for (int i = 0; i<=rand.nextInt(5) + 4; i++)
        {
            Path fly = new Path();
            do
            {
                int x1 =  rand.nextInt(bound);
                int y1 =  rand.nextInt(bound);
                Point p1 = new Point(x1,y1);

                int x2 =  rand.nextInt(bound);
                int y2 =  rand.nextInt(bound);
                Point p2 = new Point(x2,y2);
                Section section = new Section(p1,p2);
                fly.addSection(section);
            }
            while (rand.nextBoolean());

            AirShip ship;
            int r = rand.nextInt(11)+15;
            int h = rand.nextInt(5)+1;
            int starTime = rand.nextInt(3)*60;
            if(rand.nextInt()%5==0)
            {
                ship = new Balloon(new Cylinder(r,h),fly,starTime);
            } else if (rand.nextInt()%4==0) {
                ship = new Helicopter(new Cylinder(r,h),fly,starTime);
            } else if (rand.nextInt()%3==0) {
                ship = new Plane(new Cylinder(r,h),fly,starTime);
            } else {
                ship = new AirShip(new Cylinder(r,h),fly,starTime);
            }
            ships.add(ship);
        }
    }
    public void renderShips(int x)
    {
        int bound = 401;
        Random rand = new Random();
        for (int i = 0; i < x; i++)
        {
            Path fly = new Path();
            do
            {
                int x1 =  rand.nextInt(bound);
                int y1 =  rand.nextInt(bound);
                Point p1 = new Point(x1,y1);

                int x2 =  rand.nextInt(bound);
                int y2 =  rand.nextInt(bound);
                Point p2 = new Point(x2,y2);
                Section section = new Section(p1,p2);

                fly.addSection(section);
            }
            while (rand.nextBoolean());

            AirShip ship;
            int r = rand.nextInt(11)+15;
            int h = rand.nextInt(5)+1;
            int starTime = rand.nextInt(1)*60;
            if(rand.nextInt()%5==0)
            {
                ship = new Balloon(new Cylinder(r,h),fly,starTime);
            } else if (rand.nextInt()%4==0) {
                ship = new Helicopter(new Cylinder(r,h),fly,starTime);
            } else if (rand.nextInt()%3==0) {
                ship = new Plane(new Cylinder(r,h),fly,starTime);
            } else {
                ship = new AirShip(new Cylinder(r,h),fly,starTime);
            }
            ships.add(ship);
        }
    }
    public void renderTestShip()
    {
        Path fly = new Path();
        Random rand = new Random();
        int x1 =  10;
        int y1 =  10;
        Point p1 = new Point(x1,y1);

        int x2 =  10;
        int y2 =  100;
        Point p2 = new Point(x2,y2);
        Section section = new Section(p1,p2);
        fly.addSection(section);

        int x3 =  100;
        int y3 =  200;
        Point p3 = new Point(x3,y3);
        fly.addPoint(p3);

        int x4 =  300;
        int y4 =  300;
        Point p4 = new Point(x4,y4);
        fly.addPoint(p4);

        AirShip ship;
        int r = rand.nextInt(11)+15;
        int h = rand.nextInt(5)+1;
        int starTime = rand.nextInt(1)*60;
        if(rand.nextInt()%5==0)
        {
            ship = new Balloon(new Cylinder(r,h),fly,starTime);
        } else if (rand.nextInt()%4==0) {
            ship = new Helicopter(new Cylinder(r,h),fly,starTime);
        } else if (rand.nextInt()%3==0) {
            ship = new Plane(new Cylinder(r,h),fly,starTime);
        } else {
            ship = new AirShip(new Cylinder(r,h),fly,starTime);
        }
        ships.add(ship);

    }
    public void clearShips() { this.ships.clear(); }
    public void addShip(AirShip s){ this.ships.add(s); }
    public void addShip(Balloon s){ this.ships.add(s); }
    public void addShip(Helicopter s){ this.ships.add(s); }
    public void addShip(Plane s){ this.ships.add(s); }

}
