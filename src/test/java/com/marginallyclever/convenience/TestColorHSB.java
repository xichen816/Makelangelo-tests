package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class TestColorHSB {
    private void assertColorsEqual(ColorHSB c,int hue,int saturation,int brightness) {
        Assertions.assertEquals(hue,c.hue);
        Assertions.assertEquals(saturation,c.saturation);
        Assertions.assertEquals(brightness,c.brightness);
    }

    @Test
    public void limitRange() {
        assertColorsEqual(new ColorHSB(),0,0,0);
        assertColorsEqual(new ColorHSB(1,0,0),1,0,0);
        assertColorsEqual(new ColorHSB(0,1,0),0,1,0);
        assertColorsEqual(new ColorHSB(0,0,1),0,0,1);
        assertColorsEqual(new ColorHSB(-1,0,0),0,0,0);
        assertColorsEqual(new ColorHSB(0,-1,0),0,0,0);
        assertColorsEqual(new ColorHSB(0,0,-1),0,0,0);
        assertColorsEqual(new ColorHSB(2,0,0),1,0,0);
        assertColorsEqual(new ColorHSB(0,2,0),0,1,0);
        assertColorsEqual(new ColorHSB(0,0,2),0,0,1);
    }

    @Test
    public void testEquals() {
        // Object is equal to itself
        ColorHSB color = new ColorHSB(-2, 4, 6);
        Assertions.assertTrue(color.equals(color));

        // Two equal objects
        ColorHSB color1 = new ColorHSB(1, 2, 1);
        ColorHSB color2 = new ColorHSB(1, 2, 1);
        Assertions.assertTrue(color1.equals(color2));

        // Different hue
        ColorHSB colorDifferentHue = new ColorHSB(0, 2, 1);
        Assertions.assertFalse(color1.equals(colorDifferentHue));

        // Different saturation
        ColorHSB colorDifferentSaturation = new ColorHSB(1, -1, 1);
        Assertions.assertFalse(color1.equals(colorDifferentSaturation));

        // Different brightness
        ColorHSB colorDifferentBrightness = new ColorHSB(1, 2, 0);
        Assertions.assertFalse(color1.equals(colorDifferentBrightness));

        // Null comparison
        Assertions.assertFalse(color1.equals(null));

        // Different class comparison
        Object differentClassObject = new Object();
        Assertions.assertFalse(color1.equals(differentClassObject));
    }
}
