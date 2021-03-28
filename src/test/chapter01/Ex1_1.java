package chapter01;

import chapter01.ex1_1.After;
import chapter01.ex1_1.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_1 {

    @Test
    @Order(1)
    void isUniqueCharsBefore() {
        assertTrue(Before.isUniqueCharsEasy(""));
        assertFalse(Before.isUniqueCharsEasy("alpha"));
        assertTrue(Before.isUniqueCharsEasy("beta"));
        assertTrue(Before.isUniqueCharsDifficult(""));
        assertFalse(Before.isUniqueCharsDifficult("alpha"));
        assertTrue(Before.isUniqueCharsDifficult("beta"));
    }

    @Test
    @Order(2) void isUniqueCharsAfter() {
        assertTrue(After.isUniqueCharsEasy(""));
        assertFalse(After.isUniqueCharsEasy("alpha"));
        assertTrue(After.isUniqueCharsEasy("beta"));
        assertTrue(After.isUniqueCharsDifficult(""));
        assertFalse(After.isUniqueCharsDifficult("alpha"));
        assertTrue(After.isUniqueCharsDifficult("beta"));
    }
}
