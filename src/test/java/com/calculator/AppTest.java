package com.calculator;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testSqrt() {
        assertEquals(4.0, App.sqrt(16), 0.0001);
    }

    @Test
    public void testFactorial() {
        assertEquals(120, App.factorial(5));
    }

    @Test
    public void testLn() {
        assertEquals(1.0, App.ln(Math.E), 0.0001);
    }

    @Test
    public void testPower() {
        assertEquals(256.0, App.power(2, 8), 0.0001);
    }
}
