package com.marginallyclever.convenience;

import com.marginallyclever.convenience.helpers.StringHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringHelper {
    @Test
    public void testPaddedHex() {
        assertEquals("000001", StringHelper.paddedHex(0x1));
        assertEquals("0007ff",StringHelper.paddedHex(0x7ff));
        assertEquals("100001",StringHelper.paddedHex(0x100001));
        assertEquals("1000001",StringHelper.paddedHex(0x1000001));
        assertEquals("100000",StringHelper.paddedHex(0x100000));
    }

    @Test
    public void testGetElapsedTime() {
        // test 0 seconds
        assertEquals("00:00:00", StringHelper.getElapsedTime(0));

        // test 59 seconds
        assertEquals("00:00:59", StringHelper.getElapsedTime(59));

        // test 60 seconds (1 minute)
        assertEquals("00:01:00", StringHelper.getElapsedTime(60));

        // test 3600 seconds (1 hour)
        assertEquals("01:00:00", StringHelper.getElapsedTime(3600));

        // test 3661 seconds (1 hour, 1 minute, 1 second)
        assertEquals("01:01:01", StringHelper.getElapsedTime(3661));

        // test 86400 seconds (24 hours)
        assertEquals("24:00:00", StringHelper.getElapsedTime(86400));

        // test 86461 seconds (24 hours, 1 minute, 1 second)
        assertEquals("24:01:01", StringHelper.getElapsedTime(86461));

        // test 100000 seconds
        assertEquals("27:46:40", StringHelper.getElapsedTime(100000));
    }
}
