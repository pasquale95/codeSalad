package chapter02.ex2_3;

import org.junit.jupiter.params.provider.Arguments;
import utils.LinkedListNode;

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
        // 13 -> 43 -> 31 -> 12 -> 15 -> 3 -> 5
        LinkedListNode<Integer> first = new LinkedListNode<>(13);
        first.append(43).append(31).append(12).append(15).append(3).append(5);
        // 13 -> 31 -> 12 -> 15 -> 3 -> 5
        LinkedListNode<Integer> second = new LinkedListNode<>(13);
        second.append(31).append(12).append(15).append(3).append(5);
        return Stream.of(
                Arguments.of(second, first, first.getNext())
        );
    }
}
