package tests;

import objects.flyingObjects.distance.Path;
import objects.flyingObjects.distance.Point;
import objects.flyingObjects.distance.Section;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PathTest {

//  checking if section is removed correctly
    @Test
    void removeSection() {
        Path newPath = new Path();
        for(int i = 1; i < 5; i++){
            int x1 = i;
            int y1 = i;
            Point p1 = new Point(x1, y1);

            int x2 = i*5;
            int y2 = i*5;
            Point p2 = new Point(x2, y2);
            Section section = new Section(p1, p2);
            newPath.addSection(section);
        }
        int size = newPath.flightPath.size();
        newPath.removeSection(0);
        assertEquals(6, size-1);
    }

//  checking if point is added to path correctly
    @Test
    void addPoint() {
        Path newPath = new Path();
        for(int i = 1; i < 5; i++){
            int x1 = i;
            int y1 = i;
            Point p1 = new Point(x1, y1);

            int x2 = i*5;
            int y2 = i*5;
            Point p2 = new Point(x2, y2);
            Section section = new Section(p1, p2);
            newPath.addSection(section);
        }
        int size = newPath.flightPath.size();
        newPath.addPoint(new Point(10,20));
        assertEquals(8, size+1);
    }
}