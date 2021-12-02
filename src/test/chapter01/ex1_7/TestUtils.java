package chapter01.ex1_7;

import org.junit.jupiter.params.provider.Arguments;
import utils.generators.ArrayGenerator;
import utils.generators.RandomGenerator;

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
                Arguments.of(
                        new Integer[][] {
                                {7,4,1},
                                {8,5,2},
                                {9,6,3}
                        },
                        new Integer[][] {
                                {1,2,3},
                                {4,5,6},
                                {7,8,9}
                        })
        );
    }
}
