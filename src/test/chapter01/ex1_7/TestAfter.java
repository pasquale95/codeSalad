package chapter01.ex1_7;

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
@DisplayName("Ex1_7: Rotate Matrix (After)")
public class TestAfter {

    @ParameterizedTest(name = "Checking matrix rotation:")
    @MethodSource("chapter01.ex1_7.TestUtils#getParameters")
    void check(Integer[][] expected, Integer[][] input) {
        After.rotateMatrix(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                assertEquals(expected[i][j], input[i][j]);
            }
        }
    }
}
