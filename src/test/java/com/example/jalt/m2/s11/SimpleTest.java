/*
 * Introduction to Java Logging and Testing
 * 
 * https://github.com/egalli64/jalt
 */
package com.example.jalt.m2.s11;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.jalt.m2.s10.Simple;

/**
 * Test case for Simple::negate() on minimum integer value with Jupiter assertThrows()
 */
class SimpleTest {
    private Simple simple = new Simple();

    /**
     * Can't negate minimum integer value
     */
    @Test
    void negateMinInt() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> simple.negate(Integer.MIN_VALUE));
        assertEquals("Can't negate MIN_VALUE", ex.getMessage());
    }
}
