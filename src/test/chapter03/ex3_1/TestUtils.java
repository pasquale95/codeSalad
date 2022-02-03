package chapter03.ex3_1;

import org.junit.jupiter.params.provider.Arguments;
import utils.LinkedListNode;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class TestUtils {

    public static final Integer STACK_SIZE = 3;

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParameters() {
        return Stream.of(
                Arguments.of(3, 0),
                Arguments.of(6, 2),
                Arguments.of(9, 1)
        );
    }
}
