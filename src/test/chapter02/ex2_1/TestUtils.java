package chapter02.ex2_1;

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
        // 3 -> 4 -> 3 -> 2 -> 5 -> 3 -> 5
        LinkedListNode<Integer> withDuplicates = new LinkedListNode<>(3);
        withDuplicates.append(4).append(3).append(2).append(5).append(3).append(5);
        // 3 -> 4 -> 2 -> 5
        LinkedListNode<Integer> noDuplicates = new LinkedListNode<>(3);
        noDuplicates.append(4).append(2).append(5);
        return Stream.of(Arguments.of(noDuplicates, withDuplicates));
    }
}
