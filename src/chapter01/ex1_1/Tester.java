package chapter01.ex1_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
class Tester {

    @Test
    void isUniqueCharsBefore() {
        assertTrue(Before.isUniqueCharsEasy(""));
        assertFalse(Before.isUniqueCharsEasy("alpha"));
        assertTrue(Before.isUniqueCharsEasy("beta"));
        assertTrue(Before.isUniqueCharsDifficult(""));
        assertFalse(Before.isUniqueCharsDifficult("alpha"));
        assertTrue(Before.isUniqueCharsDifficult("beta"));
    }

    @Test
    void isUniqueCharsAfter() {
        assertTrue(After.isUniqueCharsEasy(""));
        assertFalse(After.isUniqueCharsEasy("alpha"));
        assertTrue(After.isUniqueCharsEasy("beta"));
        assertTrue(After.isUniqueCharsDifficult(""));
        assertFalse(After.isUniqueCharsDifficult("alpha"));
        assertTrue(After.isUniqueCharsDifficult("beta"));
    }
}
