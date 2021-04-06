package chapter01;

import chapter01.ex1_4.After;
import chapter01.ex1_4.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_4 {

    @Test
    @Order(1)
    void isPermutationOfPalindromeBefore() {
        assertTrue(Before.isPermutationOfPalindrome("Tact Coa"));
        assertFalse(Before.isPermutationOfPalindrome("Tactic Coa"));
        assertTrue(Before.isPermutationOfPalindrome(""));
    }

    @Test
    @Order(2)
    void isPermutationOfPalindromeAfter() {
        assertTrue(After.isPermutationOfPalindrome("Tact Coa"));
        assertFalse(After.isPermutationOfPalindrome("Tactic Coa"));
        assertTrue(After.isPermutationOfPalindrome(""));
    }
}