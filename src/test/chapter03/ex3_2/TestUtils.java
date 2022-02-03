package chapter03.ex3_2;

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
    private static Stream<Arguments> getParametersPush() {
        return Stream.of(
                Arguments.of(7),
                Arguments.of(1),
                Arguments.of(4),
                Arguments.of(5)
        );
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersPop() {
        return Stream.of(Arguments.of(5));
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersMin() {
        return Stream.of(Arguments.of(1));
    }
}
