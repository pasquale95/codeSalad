package chapter03.ex3_3;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class TestUtils {

    public static final Integer THRESHOLD = 2;

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersPush() {
        return Stream.of(
                Arguments.of(6),
                Arguments.of(4),
                Arguments.of(3),
                Arguments.of(2)
        );
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersPopAt() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(4, 0)
        );
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersPop() {
        return Stream.of(Arguments.of(3));
    }
}
