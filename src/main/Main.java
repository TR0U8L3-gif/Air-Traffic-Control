package main;

import java.util.*;
import view.radar.*;
import view.swing.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*
         *   // generating a map in the console on the values specified by the user
         *   int time = 0; //time in minutes
         *   Random rand = new Random();
         *   Path fly[] = new Path[3];
         *   for (int i =0; i < 3; i++)
         *   {
         *       for (int j = 0; j<rand.nextInt(3); j++)
         *       {
         *       int x1 =  rand.nextInt();
         *       int y1 =  rand.nextInt();
         *       Point p1 = new Point(x1,y1);
         *
         *       int x2 =  rand.nextInt();
         *       int y2 =  rand.nextInt();
         *       Point p2 = new Point(x2,y2);
         *
         *       fly[i].addSection(new Section(p1,p2));
         *       }
         *   }
         *
         *   try (Scanner sc = new Scanner(System.in)) {
         *       Path fly = new Path();
         *
         *       System.out.println("input base flight path:");
         *      System.out.println("input point1 x and y:");
         *
         *       int x1 =  sc.nextInt();
         *       int y1 =  sc.nextInt();
         *       Point p1 = new Point(x1,y1);
         *
         *      System.out.println("input point2 x and y:");
         *
         *       int x2 =  sc.nextInt();
         *       int y2 =  sc.nextInt();
         *       Point p2 = new Point(x2,y2);
         *
         *       fly.addSection(new Section(p1,p2));
         *
         *       System.out.println(fly.toString());
         *
         *       for (int i = 0; i < 3; i++) {
         *           System.out.println("input next point of the trip x and y:");
         *
         *           int x3 =  sc.nextInt();
         *           int y3 =  sc.nextInt();
         *           Point p3 = new Point(x3,y3);
         *
         *           fly.addPoint(p3);
         *       }
         *       System.out.println(fly.toString());
         *       // removing section
         *       for (int i = 0; i < 3; i++) {
         *           System.out.println("input index of deleted section:");
         *
         *           int index =  sc.nextInt();
         *           fly.removeSection(index);
         *           System.out.println(fly.toString());
         *       }
         *       // removing point
         *       for (int i = 0; i < 4; i++) {
         *           System.out.println("input x and y of deleted point:");
         *           int x =  sc.nextInt();
         *           int y =  sc.nextInt();
         *           fly.removePoint(new Point(x,y));
         *           System.out.println(fly.toString());
         *       }
         *   }
		 */

		/*
         *  // checking if objects generate correctly
         *   List<StaticObject> objects.staticObjects = new ArrayList<StaticObject>();
         *   Random rand = new Random();
         *   while(true)
         *   {
         *       if(rand.nextInt(2)%2==0)
         *       {
         *           objects.staticObjects.add(new Tree());
         *       }
         *      else
         *       {
         *           objects.staticObjects.add(new Building());
         *       }
         *       System.out.println(objects.staticObjects.get(objects.staticObjects.size()-1).toString());
         *       try
         *       {
         *           TimeUnit.SECONDS.sleep(10);
         *       }
         *       catch (InterruptedException e)
         *       {
         *           e.printStackTrace();
         *       }
         *   }
         *
		 */

        Radar radar = new Radar();

        /*
         *   // testing rendered flying objects position
         *   view.radar.renderTestShip();
         *   view.radar.renderShips(1);
         *   view.radar.renderStaticObjects();
         *   view.radar.showShips();
         *   view.radar.showStaticObjects();
         */

        Scanner sc = new Scanner(System.in);
        new StartPage(radar);


    }
}