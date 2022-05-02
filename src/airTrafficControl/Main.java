package airTrafficControl;

import java.util.*;
import java.util.concurrent.TimeUnit;

import distance.*;
import airship.*;
import staticObjects.StaticObject;
import swing.*;

public class Main {

    public static void main(String[] args) {

		/*
		try (Scanner sc = new Scanner(System.in)) {
			Path fly = new Path();

			System.out.println("input base flight path:");
			System.out.println("input point1 x and y:");

			int x1 =  sc.nextInt();
			int y1 =  sc.nextInt();
			Point p1 = new Point(x1,y1);

			System.out.println("input point2 x and y:");

			int x2 =  sc.nextInt();
			int y2 =  sc.nextInt();
			Point p2 = new Point(x2,y2);

			fly.addSection(new Section(p1,p2));

			System.out.println(fly.toString());

			for (int i = 0; i < 3; i++) {
				System.out.println("input next point of the trip x and y:");

				int x3 =  sc.nextInt();
				int y3 =  sc.nextInt();
				Point p3 = new Point(x3,y3);

				fly.addPoint(p3);
			}
			System.out.println(fly.toString());
//			removing section
//			for (int i = 0; i < 3; i++) {
//				System.out.println("input index of deleted section:");
//
//				int index =  sc.nextInt();
//				fly.removeSection(index);
//				System.out.println(fly.toString());
//			}
//			removing point
			for (int i = 0; i < 4; i++) {
				System.out.println("input x and y of deleted point:");
				int x =  sc.nextInt();
				int y =  sc.nextInt();
				fly.removePoint(new Point(x,y));
				System.out.println(fly.toString());
			}
		}
		*/


        /*
		List<StaticObject> staticObjectsList = new ArrayList<StaticObject>();

		Random rand = new Random();
		while(true)
		{
			if(rand.nextInt(2)%2==0)
			{
				staticObjects.add(new Tree());
			}
			else
			{
				staticObjects.add(new Building());
			}
			System.out.println(staticObjects.get(staticObjects.size()-1).toString());
			try
			{
				TimeUnit.SECONDS.sleep(10);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		*/

        new StartPage();
    }
}