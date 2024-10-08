package com.marginallyclever.convenience.noise;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class TestPerlinNoise {
    @Test
    public void testNoise(){
        //Since the function generates pseudo random values I won't assert with exact values but instead just test
        // if the returned value is within the accepted range

        PerlinNoise pNoise = new PerlinNoise();
        double noise;

        //all zeros
        noise = pNoise.noise(0, 0, 0);
        Assertions.assertTrue(noise <= 1.0 && noise >= -1.0, "Noise value is out of range");

        //negative values
        noise = pNoise.noise(-307.593, -280.6423, -730.6547);
        Assertions.assertTrue(noise <= 1.0 && noise >= -1.0, "Noise value is out of range");

        //random normal values
        noise = pNoise.noise(164.1628, 81.8807, 934.3651);
        Assertions.assertTrue(noise <= 1.0 && noise >= -1.0, "Noise value is out of range");

        //negative, positive and a zero
        noise = pNoise.noise(-278.1238, 0, 348.0338);
        Assertions.assertTrue(noise <= 1.0 && noise >= -1.0, "Noise value is out of range");
        System.out.println("12345678");
    }
}
