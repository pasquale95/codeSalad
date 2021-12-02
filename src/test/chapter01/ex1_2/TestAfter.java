package chapter01.ex1_2;

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
@Tag("After")
@DisplayName("Ex1_2: Check permutations (After)")
public class TestAfter {

    @ParameterizedTest(name = "Checking if words \"{1}\" and \"{2}\" are permutations:")
    @MethodSource("chapter01.ex1_2.TestUtils#getParameters")
    void check(Boolean expected, String a, String b) {
        assertEquals(expected, After.arePermutations(a, b));
    }
}
