package chapter03.ex3_4;

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
    private static Stream<Arguments> getParametersAdd() {
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
    private static Stream<Arguments> getParametersRemove() {
        return Stream.of(
                Arguments.of(6),
                Arguments.of(4)
        );
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersPeek() {
        return Stream.of(Arguments.of(3));
    }
}
