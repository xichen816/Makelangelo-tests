package com.marginallyclever.convenience;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestLineInterpolator {
    @Test
    public void testGetPoint() {

        // Créer une instance de LineInterpolator avec un point de départ et un point de fin.
        Point2D result = new Point2D();
        Point2D start = new Point2D(0, 0);
        Point2D end = new Point2D(10, 10);
        LineInterpolator line = new LineInterpolator(start, end);

        // Tester avec différentes valeurs du paramètre t comprises entre 0 et 1.
        // t = 0, minimum
        line.getPoint(0.0, result);
        assertEquals(0.0, result.x, 0.001);
        assertEquals(0.0, result.y, 0.001);

        // t = 0.25
        line.getPoint(0.25, result);
        assertEquals(2.5, result.x, 0.001);
        assertEquals(2.5, result.y, 0.001);

        // t = 0.5
        line.getPoint(0.5, result);
        assertEquals(5.0, result.x, 0.001);
        assertEquals(5.0, result.y, 0.001);

        // t = 0.75
        line.getPoint(0.75, result);
        assertEquals(7.5, result.x, 0.001);
        assertEquals(7.5, result.y, 0.001);

        // t = 1, maximum
        line.getPoint(1.0, result);
        assertEquals(10, result.x, 0.001);
        assertEquals(10, result.y, 0.001);
    }
    @Test
    public void testGetTangent() {

        //
        Point2D tangent = new Point2D();
        Point2D start = new Point2D(0, 0);
        Point2D end = new Point2D(10, 10);
        LineInterpolator line = new LineInterpolator(start, end);

        // Tester la tangente entre les bornes t = [0, 1]
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

        // Vérifier le comportement de la tangente lorsque t = 1 - SMALL_VALUE
        line.getTangent(0.9999, tangent);
        assertEquals(0.7071, tangent.x, 1e-5);
        assertEquals(0.7071, tangent.y, 1e-5);

    }
}
