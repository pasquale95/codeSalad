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
    void isUniqueBefore() {
        assertTrue(Before.isUniqueCharsA(""));
        assertFalse(Before.isUniqueCharsA("alpha"));
        assertTrue(Before.isUniqueCharsA("beta"));
        assertTrue(Before.isUniqueCharsB(""));
        assertFalse(Before.isUniqueCharsB("alpha"));
        assertTrue(Before.isUniqueCharsB("beta"));
    }

    @Test
    @Order(2) void isUniqueAfter() {
        assertTrue(After.isUniqueCharsA(""));
        assertFalse(After.isUniqueCharsA("alpha"));
        assertTrue(After.isUniqueCharsA("beta"));
        assertTrue(After.isUniqueCharsB(""));
        assertFalse(After.isUniqueCharsB("alpha"));
        assertTrue(After.isUniqueCharsB("beta"));
    }
}
