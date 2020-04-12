package at.fitosoft.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExponentsTest {
    private static final double DELTA = 0.0001;

    @Test
    void significant() {
        assertEquals(1.23, Exponents.significant(123000.), DELTA);
        assertEquals(9.23, Exponents.significant(923000.), DELTA);
        assertEquals(9.999999, Exponents.significant(9999999.), DELTA);
        assertEquals(9.323, Exponents.significant(0.009323), DELTA);
        assertEquals(4.323, Exponents.significant(0.004323), DELTA);
        assertEquals(1., Exponents.significant(1.), DELTA);
        assertEquals(1., Exponents.significant(-1.), DELTA);
        assertEquals(2.4789, Exponents.significant(2.4789E231), DELTA);

        assertTrue(Double.isNaN(Exponents.significant(0)));
    }
}