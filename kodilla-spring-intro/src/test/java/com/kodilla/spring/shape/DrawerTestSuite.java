package com.kodilla.spring.intro.shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrawerTestSuite {
    @Test
    public void testDoDrawingCircle(){
        //G
        Circle circle = new Circle();
        //W
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
        //T
        assertEquals("Circle", result);
    }

    @Test
    public void testDoDrawingTriangle(){
        //G
        Triangle triangle = new Triangle();
        //W
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();
        //T
        assertEquals("Triangle", result);
    }

}