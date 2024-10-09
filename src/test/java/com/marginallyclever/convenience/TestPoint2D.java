package com.marginallyclever.convenience;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TestPoint2D {

    @Test
    public void testDistanceSquared() {
        Point2D o = new Point2D(5, 10);
        Point2D p = new Point2D(-3, 4);
        Point2D q = new Point2D(2, 6);

        assertEquals(100.0, o.distanceSquared(p), 0.001);
        assertEquals(29.0, q.distanceSquared(p), 0.001);
        assertEquals(25.0, o.distanceSquared(q), 0.001);
    }
    @Test
    public void testEqualsEpsilon() {

        Point2D p1 = new Point2D(1.00000001, 2.0);
        Point2D p2 = new Point2D(1.0, 2.0);
        Point2D p3 = new Point2D(1.0001, 2.0);
        double epsilon1 = 1e-8;
        double epsilon2 = 1e-6;

        // distance < epsilon
        assertTrue(p1.equalsEpsilon(p2, epsilon1));
        assertTrue(p1.equalsEpsilon(p2, epsilon2));

        // distance > epsilon
        assertFalse(p1.equalsEpsilon(p3, epsilon1));
        assertFalse(p1.equalsEpsilon(p3, epsilon2));
    }
}
