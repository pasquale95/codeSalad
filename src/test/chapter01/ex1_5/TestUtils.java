package chapter01.ex1_5;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class TestUtils {

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(true, "pales", "pale"),
                Arguments.of(true, "pale", "ple"),
                Arguments.of(true, "pale", "bale"),
                Arguments.of(false, "pale", "bake"),
                Arguments.of(false, "pale", "bales"),
                Arguments.of(false, "pale", "bal")
        );
    }
}
