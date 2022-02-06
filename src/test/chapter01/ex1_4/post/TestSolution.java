package chapter01.ex1_4.post;

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
@Tag("Post")
@DisplayName("Ex1_4: Palindrome Permutation (Post)")
public class TestSolution {

    @ParameterizedTest(name = "Checking if word \"{1}\" is permutation of a palindrome:")
    @MethodSource("chapter01.ex1_4.TestUtils#getParameters")
    void check(Boolean expected, String input) {
        assertEquals(expected, Solution.isPermutationOfPalindrome(input));
    }
}
