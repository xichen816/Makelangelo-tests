package com.marginallyclever.convenience;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestHistogram {
    @Test
    public void testGetRGBHistogramOf(){
        BufferedImage mockImg = mock(BufferedImage.class);
        Histogram histogram = new Histogram();
        char[] testRed = new char[256];
        char[] testGreen = new char[256];
        char[] testBlue = new char[256];
        for (int i = 0; i < 255; ++i) {
            testRed[i] = 0;
            testGreen[i] = 0;
            testBlue[i] = 0;
        }

        //case when image is 0x0 pixels, getRGB returns base 10 value of color hexcode
        when(mockImg.getWidth()).thenReturn(0);
        when(mockImg.getHeight()).thenReturn(0);
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xffffffff);
        histogram.getRGBHistogramOf(mockImg);
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);

        //case when image is all red
        when(mockImg.getWidth()).thenReturn(25);
        when(mockImg.getHeight()).thenReturn(1);
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xffff0000);
        histogram.getRGBHistogramOf(mockImg);
        testRed[255] = 25;
        testGreen[0] = 25;
        testBlue[0] = 25;
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);

        //case when all green
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xff00ff00);
        histogram.getRGBHistogramOf(mockImg);
        testRed[255] = 0;
        histogram.red[255] = 0;
        testGreen[0] = 0;
        testGreen[255] = 25;
        testRed[0] = 25;
        testBlue[0] = 25;
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);

        //case when all blue
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xff0000ff);
        histogram.getRGBHistogramOf(mockImg);
        testGreen[255] = 0;
        histogram.green[255] = 0;
        testBlue[255] = 25;
        testBlue[0] = 0;
        testGreen[0] = 25;
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);

        //case when all pixels are black
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xff000000);
        histogram.getRGBHistogramOf(mockImg);
        histogram.blue[255] = 0;
        testBlue[255] = 0;
        testBlue[0] =25;
        testGreen[0] = 25;
        testRed[0] = 25;
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);

        //case when all pixels are white
        when(mockImg.getRGB(anyInt(), anyInt())).thenReturn(0xffffffff);
        histogram.getRGBHistogramOf(mockImg);
        testRed[255] = 25;
        testGreen[255] = 25;
        testBlue[255] = 25;
        testBlue[0] = 0;
        testGreen[0] = 0;
        testRed[0] = 0;
        assertArrayEquals(testRed, histogram.red);
        assertArrayEquals(testGreen, histogram.green);
        assertArrayEquals(testBlue, histogram.blue);
    }
}
