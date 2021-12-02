package chapter01.ex1_3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.generators.StringGenerator.toCharsWithExtraRoom;


/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Before")
@DisplayName("Ex1.3: URLify (Before)")
public class TestBefore {

    @ParameterizedTest(name = "Urlifying word \"{1}\" to \"{0}\":")
    @MethodSource("chapter01.ex1_3.TestUtils#getParameters")
    void check(String expected, String input) {
        assertEquals(expected, Before.urlify(toCharsWithExtraRoom(input), input.length()));
    }
}
