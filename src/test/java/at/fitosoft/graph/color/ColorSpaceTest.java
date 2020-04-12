package at.fitosoft.graph.color;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorSpaceTest {

    @Test
    void testColors() {
        ColorSpace s = new ColorSpace(Arrays.asList(
                new Color(100, 0, 0), new Color(0, 100, 0), new Color(0, 0, 100)),
                1);

        assertEquals(5, s.colors().size());
    }

    @Test
    void testGetColor() {
        ColorSpace s = new ColorSpace(Arrays.asList(
                new Color(100, 0, 0), new Color(0, 100, 0), new Color(0, 0, 100)),
                1);

        assertEquals(new Color(100, 0, 0), s.getColor(0));
        assertEquals(new Color(50, 50, 0), s.getColor(1));
        assertEquals(new Color(0, 100, 0), s.getColor(2));
        assertEquals(new Color(0, 50, 50), s.getColor(3));
        assertEquals(new Color(0, 0, 100), s.getColor(4));
    }

}