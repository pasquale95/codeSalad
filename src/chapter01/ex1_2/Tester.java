package chapter01.ex1_2;

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
    void arePalindromeBeforeQuestion() {
        assertTrue(Before.arePermutations("stressed", "desserts"));
        assertTrue(Before.arePermutations("", ""));
        assertFalse(Before.arePermutations("stressed", "genesis"));
        assertTrue(Before.arePermutations("the classroom", "school master"));
    }

    @Test
    void arePalindromeAfterQuestion() {
        assertTrue(After.arePermutations("stressed", "desserts"));
        assertTrue(After.arePermutations("", ""));
        assertFalse(After.arePermutations("stressed", "genesis"));
        assertTrue(Before.arePermutations("the classroom", "school master"));
    }
}