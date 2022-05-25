package tests;

import radar.Radar;

import static org.junit.jupiter.api.Assertions.*;

class RadarTest {

    @org.junit.jupiter.api.Test
    void isShipsRenderingCorrect(){
        Radar newRadar = new Radar();
        newRadar.renderShips(4);
        int ships = newRadar.ships.size();
        assertEquals(4, ships);

    }
    @org.junit.jupiter.api.Test
    void isStaticObjectsRenderingCorrect(){
        Radar newRadar = new Radar();
        newRadar.renderStaticObjects(8);
        int staticObjects = newRadar.staticObjects.size();
        assertEquals(8, staticObjects);

    }

}