package chapter02;

import chapter02.ex2_6.After;
import chapter02.ex2_6.Before;
import org.junit.jupiter.api.*;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex2_6 {

    private static LinkedListNode palindrome, notPalindrome;

    @BeforeAll
    static void init() {
        palindrome = new LinkedListNode(6);
        palindrome.append(5).append(3).append(5).append(6);
        notPalindrome = palindrome.clone();
        notPalindrome.append(7);
    }

    @Test
    @Order(1)
    void palindromeBefore() {
        assertTrue(Before.isPalindrome(palindrome));
        assertTrue(Before.isPalindrome(new LinkedListNode(2)));
        assertTrue(Before.isPalindrome(null));
        assertFalse(Before.isPalindrome(notPalindrome));
    }

    @Test
    @Order(2)
    void palindromeAfter() {
        assertTrue(After.isPalindrome(palindrome));
        assertTrue(After.isPalindrome(new LinkedListNode(2)));
        assertTrue(After.isPalindrome(null));
        assertFalse(After.isPalindrome(notPalindrome));
    }
}