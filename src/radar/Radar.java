package radar;

import java.util.*;
import airship.*;
import distance.*;
import figure.Cylinder;
import staticObjects.*;
import swing.MyFrame;

import javax.swing.*;

public class Radar {
    public int time = 0;
    public List<StaticObject> staticObjects = new ArrayList<>();
    public List<AirShip> ships = new ArrayList<>();

    public void setTime(int time) { this.time = time; }
    public int getTime() { return this.time; }

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
        Random rand = new Random();
        for (int i = 0; i<=rand.nextInt(5) + 1; i++)
        {
            Path fly = new Path();
            do
            {
                int x1 =  rand.nextInt(51);
                int y1 =  rand.nextInt(51);
                Point p1 = new Point(x1,y1);

                int x2 =  rand.nextInt(51);
                int y2 =  rand.nextInt(51);
                Point p2 = new Point(x2,y2);
                Section section = new Section(p1,p2);
                section.setHeight(rand.nextInt(101)*100);
                section.setSpeed(rand.nextInt(291)+10);
                fly.addSection(section);
            }
            while (rand.nextBoolean());
            AirShip ship = new AirShip(new Cylinder(rand.nextInt(7)+5, rand.nextInt(5)+1),fly);
            ships.add(ship);
        }
    }
    public void renderShips(int x)
    {
        Random rand = new Random();
        for (int i = 0; i < x; i++)
        {
            Path fly = new Path();
            do
            {
                int x1 =  rand.nextInt(51);
                int y1 =  rand.nextInt(51);
                Point p1 = new Point(x1,y1);

                int x2 =  rand.nextInt(51);
                int y2 =  rand.nextInt(51);
                Point p2 = new Point(x2,y2);
                Section section = new Section(p1,p2);
                section.setHeight(rand.nextInt(101)*100);
                section.setSpeed(rand.nextInt(291)+10);
                fly.addSection(section);
            }
            while (rand.nextBoolean());
            AirShip ship = new AirShip(new Cylinder(rand.nextInt(7)+5, rand.nextInt(5)+1),fly);
            ships.add(ship);
        }
    }
    public void clearShips() { this.ships.clear(); }
    public void addShip(AirShip s){ this.ships.add(s); }
    public void addShip(Balloon s){ this.ships.add(s); }
    public void addShip(Helicopter s){ this.ships.add(s); }
    public void addShip(Plane s){ this.ships.add(s); }
}
