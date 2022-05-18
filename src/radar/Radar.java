package radar;

import java.util.*;
import airship.*;
import distance.*;
import figure.Cylinder;
import staticObjects.*;

public class Radar {
    public double time = 0;
    public List<StaticObject> staticObjects = new ArrayList<>();
    public List<AirShip> ships = new ArrayList<>();
    private int offset = 30;
    public void setTime(double time) {
        this.time = time;
    }

    public double getTime() {
        return this.time;
    }

    public int countStaticObjects() {
        return this.staticObjects.size();
    }

    public String showStaticObjects() {
        String msg = "Static Objects: \n";
        System.out.println("static objects: ");
        for (int i = 0; i < staticObjects.size(); i++) {
            msg += (i + 1) + ") " + staticObjects.get(i).toString() + "\n";
            System.out.println(staticObjects.get(i));
            //System.out.println(staticObjects.get(i).getX());
            //System.out.println(staticObjects.get(i).getY());
        }
        return msg;
    }

    public void renderStaticObjects() {
        Random rand = new Random();
        for (int i = 0; i <= rand.nextInt(5) + 1; i++) {
            if (rand.nextBoolean()) {
                this.staticObjects.add(new Tree());
            } else {
                this.staticObjects.add(new Building());
            }
        }
    }

    public void renderStaticObjects(int x) {
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            if (rand.nextBoolean()) {
                this.staticObjects.add(new Tree());
            } else {
                this.staticObjects.add(new Building());
            }
            System.out.println(staticObjects.get(i).toString());
        }
    }

    public void removeStaticObject(int index) {
        if (index >= 0 && index < this.staticObjects.size())
            this.staticObjects.remove(index);
    }

    public void removeAirShips(int index) {
        if (index >= 0 && index < this.ships.size())
            this.ships.remove(index);
    }

    public void clearStaticObjects() {
        this.staticObjects.clear();
    }

    public void addTree(Tree tree) {
        this.staticObjects.add(tree);
    }

    public void addBuilding(Building build) {
        this.staticObjects.add(build);
    }

    public void removeTree(Tree tree) {
        try {
            this.staticObjects.remove(tree);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeBuilding(Building build) {
        try {
            this.staticObjects.remove(build);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int countShips() {
        return this.ships.size();
    }

    public String showShips() {
        String msg = "Airships: \n";
        System.out.println("ships: ");
        for (int i = 0; i < ships.size(); i++) {
            msg += (i + 1) + ") " + ships.get(i).toString() + "\n";
            System.out.println(this.ships.get(i));
        }
        return msg;
    }

    public void renderShips() {
        int bound = 401;
        Random rand = new Random();
        for (int i = 0; i <= rand.nextInt(5) + 4; i++) {
            Path fly = new Path();
            do {
                int x1 = rand.nextInt(bound)+offset;
                int y1 = rand.nextInt(bound)+offset;
                Point p1 = new Point(x1, y1);

                int x2 = rand.nextInt(bound)+offset;
                int y2 = rand.nextInt(bound)+offset;
                Point p2 = new Point(x2, y2);
                Section section = new Section(p1, p2);
                fly.addSection(section);
            }
            while (rand.nextBoolean());

            AirShip ship;
            int r = rand.nextInt(11) + 15;
            int h = rand.nextInt(5) + 1;
            int starTime = rand.nextInt(3) * 60;
            if (rand.nextInt() % 5 == 0) {
                ship = new Balloon(new Cylinder(r, h), fly, starTime);
            } else if (rand.nextInt() % 4 == 0) {
                ship = new Helicopter(new Cylinder(r, h), fly, starTime);
            } else if (rand.nextInt() % 3 == 0) {
                ship = new Plane(new Cylinder(r, h), fly, starTime);
            } else {
                ship = new AirShip(new Cylinder(r, h), fly, starTime);
            }
            ships.add(ship);
        }
    }

    public void renderShips(int x) {
        int bound = 401;
        Random rand = new Random();
        for (int i = 0; i < x; i++) {
            Path fly = new Path();
            do {
                int x1 = rand.nextInt(bound);
                int y1 = rand.nextInt(bound);
                Point p1 = new Point(x1, y1);

                int x2 = rand.nextInt(bound);
                int y2 = rand.nextInt(bound);
                Point p2 = new Point(x2, y2);
                Section section = new Section(p1, p2);

                fly.addSection(section);
            }
            while (rand.nextBoolean());

            AirShip ship;
            int r = rand.nextInt(11) + 15;
            int h = rand.nextInt(5) + 1;
            int starTime = rand.nextInt(1) * 60;
            if (rand.nextInt() % 5 == 0) {
                ship = new Balloon(new Cylinder(r, h), fly, starTime);
            } else if (rand.nextInt() % 4 == 0) {
                ship = new Helicopter(new Cylinder(r, h), fly, starTime);
            } else if (rand.nextInt() % 3 == 0) {
                ship = new Plane(new Cylinder(r, h), fly, starTime);
            } else {
                ship = new AirShip(new Cylinder(r, h), fly, starTime);
            }
            ships.add(ship);
        }
    }

    public void renderTestShip() {
        Path fly = new Path();
        Random rand = new Random();
        int x1 = 10;
        int y1 = 10;
        Point p1 = new Point(x1, y1);

        int x2 = 10;
        int y2 = 100;
        Point p2 = new Point(x2, y2);
        Section section = new Section(p1, p2);
        fly.addSection(section);

        int x3 = 100;
        int y3 = 200;
        Point p3 = new Point(x3, y3);
        fly.addPoint(p3);

        int x4 = 300;
        int y4 = 300;
        Point p4 = new Point(x4, y4);
        fly.addPoint(p4);

        AirShip ship;
        int r = rand.nextInt(11) + 15;
        int h = rand.nextInt(5) + 1;
        int starTime = rand.nextInt(1) * 60;
        if (rand.nextInt() % 5 == 0) {
            ship = new Balloon(new Cylinder(r, h), fly, starTime);
        } else if (rand.nextInt() % 4 == 0) {
            ship = new Helicopter(new Cylinder(r, h), fly, starTime);
        } else if (rand.nextInt() % 3 == 0) {
            ship = new Plane(new Cylinder(r, h), fly, starTime);
        } else {
            ship = new AirShip(new Cylinder(r, h), fly, starTime);
        }
        ships.add(ship);

    }

    public void clearShips() {
        this.ships.clear();
    }

    public void addShip(AirShip s) {
        this.ships.add(s);
    }

    public void addShip(Balloon s) {
        this.ships.add(s);
    }

    public void addShip(Helicopter s) {
        this.ships.add(s);
    }

    public void addShip(Plane s) {
        this.ships.add(s);
    }

    public boolean isSafeAirShip(AirShip s, AirShip r) {
        double heightDiff = Math.abs(s.getCurrentHeight() - r.getCurrentHeight());
        double radiusDiff = Math.abs(s.getRadius() + r.getRadius());
        double xyDiff = Math.sqrt((r.getX() - s.getX()) * (r.getX() - s.getX()) + (r.getY() - s.getY()) * (r.getY() - s.getY()));
        if(s.getCurrentHeight()==0 || r.getCurrentHeight()==0){
            return true;
        }
        else if ((heightDiff < 50) && (xyDiff < radiusDiff)) {
            return false;
        } else
        {
            return true;
        }

    }

    public boolean isSafeStaticObject(AirShip s, StaticObject r) {
        double heightDiff = Math.abs(s.getCurrentHeight() - r.getHeight());
        double radiusDiff = Math.abs(s.getRadius() + r.getRadius());
        double xyDiff = Math.sqrt((r.getX() - s.getX()) * (r.getX() - s.getX()) + (r.getY() - s.getY()) * (r.getY() - s.getY()));
        if(s.getCurrentHeight()==0){
            return true;
        }
        else if ((heightDiff < 50) && (xyDiff < radiusDiff)) {
            return false;
        } else {
            return true;
        }
    }
    public double maxFlightTime ()
    {
        double maxTime = ships.get(0).getFlightTime() + ships.get(0).getStartTime();
        for (int i = 1; i < countShips(); i++)
        {
            double actualTime = ships.get(i).getFlightTime() + ships.get(i).getStartTime();
            if(actualTime > maxTime)
            {
                maxTime = actualTime;
            }
        }
        return maxTime;
    }
    public double maxDistance()
    {
        double maxDistabce = 0;
        double maxX = 0;
        double minX = Double.MAX_VALUE;
        double maxY = 0;
        double minY = Double.MAX_VALUE;
        for (int i = 0; i < countShips(); i++)
        {
            for (int j = 0; j < ships.get(i).airPath.flightPath.size(); j++)
            {
                double x1 = ships.get(i).airPath.flightPath.get(j).getStartPoint().getX();
                double y1 = ships.get(i).airPath.flightPath.get(j).getStartPoint().getY();
                if(maxX < x1) { maxX = x1; }
                if(maxY < y1) { maxY = y1; }
                if(minX > x1) { minX = x1; }
                if(minY > y1) { minY = y1; }
                if(j == ships.get(i).airPath.flightPath.size() -1)
                {
                    double x2 = ships.get(i).airPath.flightPath.get(j).getEndPoint().getX();
                    double y2 = ships.get(i).airPath.flightPath.get(j).getEndPoint().getY();
                    if(maxX < x2) { maxX = x2; }
                    if(minX > x2) { minX = x2; }
                    if(maxY < y2) { maxY = y2; }
                    if(minY > y2) { minY = y2; }
                }
            }
        }
        double maxXValue = -minX + maxX;
        double maxYValue = -minY + maxY;
        if(maxXValue > maxYValue)
        {
            return  maxXValue;
        }
        else
        {
            return  maxYValue;
        }
    }


}


