package com.marginallyclever.convenience;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLineInterpolatorSinCurve {
    @Test
    public void testGetPoint() {
        // Create two points defining the line segment
        Point2D start = new Point2D(0, 0);
        Point2D end = new Point2D(10, 0);
        LineInterpolatorSinCurve line = new LineInterpolatorSinCurve(start, end);

        // Set amplitude and scale
        line.setAmplitude(1.0);
        line.setScale(1.0);

        Point2D result = new Point2D();

        // t = 0
        line.getPoint(0.0, result);
        assertEquals(start.x, result.x, 1e-5);
        assertEquals(start.y, result.y, 1e-5);

        // t = 0.25
        line.getPoint(0.25, result);
        assertEquals(2.5, result.x, 1e-5);
        assertEquals(-5.0, result.y, 1e-5);

        // t = 0.5
        line.getPoint(0.5, result);
        assertEquals(5.0, result.x, 1e-5);
        assertEquals(0.0, result.y, 1e-5);

        // t = 0.75
        line.getPoint(0.75, result);
        assertEquals(7.5, result.x, 1e-5);
        assertEquals(5.0, result.y, 1e-5);

        // t = 1.0
        line.getPoint(1.0, result);
        assertEquals(end.x, result.x, 1e-5);
        assertEquals(start.y, result.y, 1e-5);
    }
}
