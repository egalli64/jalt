/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s6;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Jupiter assertions
 */
class SimpleTest {
    /**
     * Each test in this case work on an object created in the same way. There is no
     * need of a specific definition for each one, just put it at class level.
     */
    private Simple simple = new Simple();

    /**
     * Use of Assertions.assertTrue()
     */
    @Test
    void isPositiveWhenPositiveThenTrue() {
        int input = 12;
        boolean actual = simple.isPositive(input);

        // compact way of saying that actual is expected to be true
        assertTrue(actual);
    }

    /**
     * Use of Assertions.assertFalse()
     */
    @Test
    void isPositiveWhenNegativeThenFalse() {
        int input = -42;
        boolean actual = simple.isPositive(input);

        // compact way of saying that actual is expected to be false
        assertFalse(actual);
    }

    /**
     * Use of Assertions.assertNull()
     */
    @Test
    void nullIfPositiveWhenPositiveThenNull() {
        int input = 42;
        String actual = simple.nullIfPositive(input);

        // compact way of saying that actual is expected to be null
        assertNull(actual);
    }

    /**
     * Use of Assertions.assertNotNull()
     */
    @Test
    void nullIfPositiveWhenNegativeThenNotNull() {
        int input = -42;
        String actual = simple.nullIfPositive(input);

        // compact way of saying that actual is expected not to be null
        assertNotNull(actual);
    }

    /**
     * Use of Assertions.assertEquals()
     */
    @Test
    void negateWhenPositiveThenEqualsToNegated() {
        int input = 42;
        int actual = simple.negate(input);
        int expected = -input;

        assertEquals(expected, actual);
    }

    /**
     * Assert that two primitive values (integers) are different
     */
    @Test
    void negateWhenPositiveThenNotEqualsToSelf() {
        int input = 42;
        int actual = simple.negate(input);

        // input is not expected to be equals to actual
        assertNotEquals(input, actual);
    }

    /**
     * Assert that two doubles are close enough to be considered equal
     * <p>
     * With a lower delta the assertion should fail
     */
    @Test
    void multiply_WhenCloseEnough_ThenEqualsWithDelta() {
        double first = .29;
        double second = 3.0;
        double actual = simple.multiply(first, second);
        double expected = .87;

        // due to representation problems exact comparison would fail
//      assertEquals(expected, actual);

        // when only a very tiny difference is accepted
        assertEquals(expected, actual, .000_000_000_000_000_2);

        // when a wide difference is accepted
//        assertEquals(expected, actual, .1);
    }

    /**
     * Assert that two doubles are distant enough to be considered different
     * <p>
     * With a higher delta the assertion should fail
     */
    @Test
    void multiply_WhenDistantEnough_ThenNotEqualsWithDelta() {
        double first = .29;
        double second = 3.0;
        double actual = simple.multiply(first, second);
        double expected = .87;
        assertNotEquals(expected, actual, .000_000_000_000_000_1);
    }
}
