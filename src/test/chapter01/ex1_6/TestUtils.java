package chapter01.ex1_6;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

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
                Arguments.of("a3b3c1d2a2A5Z3", "aaabbbcddaaAAAAAZZZ"),
                Arguments.of("aaSSccddEfff", "aaSSccddEfff"),
                Arguments.of("qwertyuiop", "qwertyuiop")
        );
    }
}
