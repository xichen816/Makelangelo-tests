package com.marginallyclever.makelangelo.rangeslider;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRangeSlider {
    @Test
    public void testSetValue() {

        // setting a value
        RangeSlider rangeSlider = new RangeSlider(0, 10);
        rangeSlider.setValue(5);
        assertEquals(5, rangeSlider.getValue());

        // setting a lower value
        rangeSlider.setValue(4);
        assertEquals(4, rangeSlider.getValue());
        assertEquals(1, rangeSlider.getExtent());

        // setting  a higher value
        rangeSlider.setValue(3);
        rangeSlider.setValue(4);
        assertEquals(4, rangeSlider.getValue());
        assertEquals(1, rangeSlider.getExtent());

        // setting the minimum value
        rangeSlider.setValue(0);
        assertEquals(0, rangeSlider.getValue());

        // set the maximum value
        rangeSlider.setUpperValue(10);
        rangeSlider.setValue(9);
        assertEquals(9, rangeSlider.getValue());
        assertEquals(1, rangeSlider.getExtent());

        // try to set below minimum
        rangeSlider.setValue(-1);
        assertEquals(0, rangeSlider.getValue(), "should not go below minimum");

        // try to set above maximum
        rangeSlider.setValue(11);
        assertEquals(10, rangeSlider.getValue(), "should not go above maximum");
    }
}
