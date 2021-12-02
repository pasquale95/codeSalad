package chapter01.ex1_3;

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
                Arguments.of("Mr%20John%20Smith", "Mr John Smith"),
                Arguments.of("%20Mr%20", " Mr "),
                Arguments.of("%20%20%20%20%20", "     "),
                Arguments.of("", "")
        );
    }
}
