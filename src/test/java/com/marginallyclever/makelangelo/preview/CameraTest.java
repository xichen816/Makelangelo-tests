package com.marginallyclever.makelangelo.preview;

import com.marginallyclever.convenience.Point2D;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class CameraTest {
    @Test
    public void testZoom(){
        Camera camera = new Camera();
        double initZoom = camera.getZoom();
        double initX = camera.getX();
        double initY = camera.getY();


        //zoom by 0, should not change anything
        camera.zoom(0, new Point2D(5, 5));
        assertEquals(initZoom, camera.getZoom());
        assertEquals(initX, camera.getX());
        assertEquals(initY, camera.getY());

        //zoom by negative number
        camera.zoom(-1, new Point2D(5, 5));
        assertEquals(1.15, camera.getZoom(), 0.00001);
        assertEquals(0.652173913, camera.getX(), 0.00001);
        assertEquals(0.652173913, camera.getY(), 0.00001);

        //see if it returns to same value if previous zoom is reverted, aka zoom by +1
        Point2D warpedPoint = camera.screenToWorldSpace(new Point2D(5, 5));
        camera.zoom(1, warpedPoint);
        assertEquals(initZoom, camera.getZoom(), 0.00001);
        assertEquals(initX, camera.getX(), 0.00001);
        assertEquals(initY, camera.getY(), 0.00001);

        //with point (0, 0) the points should not move with any zoom given camera.getX() and getY() are zero
        camera.zoom(4, new Point2D(0, 0));
        assertEquals(0.4, camera.getZoom(), 0.00001);
        assertEquals(initX, camera.getX(), 0.00001);
        assertEquals(initY, camera.getY(), 0.00001);

        //make sure zoom does not go negative
        camera.zoom(80000, new Point2D(5,5));
        assertEquals(0.25, camera.getZoom(), 0.00001);
    }
}
