package chapter01;

import chapter01.ex1_2.After;
import chapter01.ex1_2.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_2 {

    @Test
    @Order(1)
    void arePalindromeBefore() {
        Assertions.assertTrue(Before.arePermutations("stressed", "desserts"));
        assertTrue(Before.arePermutations("", ""));
        assertFalse(Before.arePermutations("stressed", "genesis"));
        assertTrue(Before.arePermutations("The classroom", "School master"));
    }

    @Test
    @Order(2)
    void arePalindromeAfter() {
        Assertions.assertTrue(After.arePermutations("stressed", "desserts"));
        assertTrue(After.arePermutations("", ""));
        assertFalse(After.arePermutations("stressed", "genesis"));
        assertTrue(After.arePermutations("The classroom", "School master"));
    }
}