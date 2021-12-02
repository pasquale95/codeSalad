package chapter01.ex1_5;

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
@DisplayName("Ex1.5: One Away (After)")
public class TestAfter {

    @ParameterizedTest(name = "Checking if word \"{1}\" and \"{2}\" are one char away:")
    @MethodSource("chapter01.ex1_5.TestUtils#getParameters")
    void check(Boolean expected, String a, String b) {
        assertEquals(expected, After.areOneAway(a, b));
    }
}
