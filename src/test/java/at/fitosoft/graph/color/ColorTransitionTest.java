package at.fitosoft.graph.color;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColorTransitionTest {

    @Test
    void colors() {
        ColorTransition t = new ColorTransition(new Color(100, 0, 0), new Color(0, 0, 0), 8);

        assertEquals(10, t.colors().size());
    }

    @Test
    void getColor() {
        ColorTransition t = new ColorTransition(new Color(100, 0, 0), new Color(0, 0, 0), 1);

        assertEquals(new Color(100, 0, 0), t.getColor(0));
        assertEquals(new Color(50, 0, 0), t.getColor(1));
        assertEquals(new Color(0, 0, 0), t.getColor(2));
    }

}