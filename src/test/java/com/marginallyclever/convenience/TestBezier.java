package com.marginallyclever.convenience;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBezier {
    @Test
    public void testGetXAt() {
        // Créer une nouvelle instance de Bezier
        Bezier bezier = new Bezier(0, 0, 1, 1, 2, 1, 3, 0);

        // Tester plusieurs valeurs de t comprises entre 0 et 1
        assertEquals(0.0, bezier.getXAt(0.0), 0.001);
        assertEquals(0.75, bezier.getXAt(0.25), 0.001);
        assertEquals(1.5, bezier.getXAt(0.5), 0.001);
        assertEquals(2.25, bezier.getXAt(0.75), 0.001);
        assertEquals(3.0, bezier.getXAt(1.0), 0.001);
    }

    @Test
    public void testGetYAt() {
        // Créer une nouvelle instance de Bezier
        Bezier bezier = new Bezier(0, 0, 0.5, 2, 1.5, 2, 2, 0);

        // Tester plusieurs valeurs de t comprises entre 0 et 1
        assertEquals(0.0, bezier.getYAt(0.0), 0.001);
        assertEquals(1.125, bezier.getYAt(0.25), 0.001);
        assertEquals(1.5, bezier.getYAt(0.5), 0.001);
        assertEquals(1.125, bezier.getYAt(0.75), 0.001);
        assertEquals(0.0, bezier.getYAt(1.0), 0.001);
    }
}
