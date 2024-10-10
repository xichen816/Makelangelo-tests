package com.marginallyclever.convenience;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLineInterpolator {
    @Test
    public void testGetTangent() {

        // Create two points defining the line segment
        Point2D tangent = new Point2D();
        Point2D start = new Point2D(0, 0);
        Point2D end = new Point2D(10, 10);
        LineInterpolator line = new LineInterpolator(start, end);

        // Test tangent within limits of t = [0, 1]
        // t = 0
        line.getTangent(0, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

        // t = 0.5
        line.getTangent(0.5, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

        // t = 1
        line.getTangent(1, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

        // Tester hors des bornes pour vérifier l'approximation
        // t < 0
        line.getTangent(-0.5, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

        // t > 1
        line.getTangent(1.5, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

        // Test SMALL_VALUE handling
        line.getTangent(0.9999, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

    }
}
