package chapter01.ex1_1.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Post")
@DisplayName("Ex1_1: Is unique (Post)")
public class TestSolution {

    @ParameterizedTest(name = "(Question A) Checking char uniqueness for word \"{1}\":")
    @MethodSource("chapter01.ex1_1.TestUtils#getParameters")
    void checkA(Boolean expected, String string) {
        assertEquals(expected, Solution.isUniqueCharsA(string));
    }

    @ParameterizedTest(name = "(Question B) Checking char uniqueness for word \"{1}\":")
    @MethodSource("chapter01.ex1_1.TestUtils#getParameters")
    void checkB(Boolean expected, String string) {
        assertEquals(expected, Solution.isUniqueCharsB(string));
    }
}
