package chapter01.ex1_1;

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
@Tag("After")
@DisplayName("Ex1_1: Is unique (After)")
public class TestAfter {

    @ParameterizedTest(name = "Checking char uniqueness for word \"{1}\":")
    @MethodSource("chapter01.ex1_1.TestUtils#getParameters")
    void check(Boolean expected, String string) {
        assertEquals(expected, After.isUniqueCharsA(string));
        assertEquals(expected, After.isUniqueCharsB(string));
    }
}
