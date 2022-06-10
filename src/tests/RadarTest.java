package tests;

import radar.Radar;

import static org.junit.jupiter.api.Assertions.*;

class RadarTest {

//  checking if flying objects generate correctly
    @org.junit.jupiter.api.Test
    void isShipsRenderingCorrect(){
        Radar newRadar = new Radar();
        newRadar.renderShips(4);
        int ships = newRadar.ships.size();
        assertEquals(4, ships);

    }
//  checking if static objects generate correctly
    @org.junit.jupiter.api.Test
    void isStaticObjectsRenderingCorrect(){
        Radar newRadar = new Radar();
        newRadar.renderStaticObjects(8);
        int staticObjects = newRadar.staticObjects.size();
        assertEquals(8, staticObjects);

    }
}