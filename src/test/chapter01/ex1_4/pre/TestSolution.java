package chapter01.ex1_4.pre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Pre")
@DisplayName("Ex1_4: Palindrome Permutation (Pre)")
public class TestSolution {
    Solution sol;

    @BeforeEach
    public void setup() {
        sol = new Solution(null);
    }

    @ParameterizedTest(name = "Checking if word \"{1}\" is permutation of a palindrome ({0}):")
    @MethodSource("chapter01.ex1_4.TestUtils#getParameters")
    void check(Boolean expected, String input) {
        assertEquals(expected, sol.isPermutationOfPalindrome(input));
    }
}
