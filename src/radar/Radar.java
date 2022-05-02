package radar;

import java.util.*;
import airship.*;
import distance.*;
import staticObjects.*;

public class Radar {
    public int time = 0;
    public List<StaticObject> staticObjects = new ArrayList<>();
    public List<AirShip> ships = new ArrayList<>();

    public void setTime(int time) { this.time = time; }
    public int getTime() { return this.time; }

    public int countStaticObjects() { return this.staticObjects.size(); }
    public void renderStaticObjects()
    {
        Random rand = new Random();
        for (int i = 0; i<=rand.nextInt(7); i++)
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



}
