package chapter01.ex1_6;

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
@Tag("Before")
@DisplayName("Ex1.6: String Compression (Before)")
public class TestBefore {

    @ParameterizedTest(name = "Checking if word \"{1}\" is compressed to \"{0}\":")
    @MethodSource("chapter01.ex1_6.TestUtils#getParameters")
    void check(String expected, String input) {
        assertEquals(expected, Before.compress(input));
    }
}
