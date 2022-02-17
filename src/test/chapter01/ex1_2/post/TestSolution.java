package chapter01.ex1_2.post;

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
@Tag("Post")
@DisplayName("Ex1_2: Check permutations (Post)")
public class TestSolution {
    Solution sol;

    @BeforeEach
    public void setup() {
        sol = new Solution(null);
    }

    @ParameterizedTest(name = "Checking if words \"{1}\" and \"{2}\" are permutations:")
    @MethodSource("chapter01.ex1_2.TestUtils#getParameters")
    void check(Boolean expected, String a, String b) {
        assertEquals(expected, sol.arePermutations(a, b));
    }
}
