package chapter02.ex2_5;

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
    private static Stream<Arguments> getParametersReverseOrderSum() {
        // 6529
        LinkedListNode<Integer> addend1 = new LinkedListNode<>(6);
        addend1.append(5).append(2).append(9);
        // 8567
        LinkedListNode<Integer> addend2 = new LinkedListNode<>(8);
        addend2.append(5).append(6).append(7);
        // 64
        LinkedListNode<Integer> addend3 = new LinkedListNode<>(6);
        addend3.append(4);
        // 9256+7658=16914
        LinkedListNode<Integer> reverseSum1 = new LinkedListNode<>(4);
        reverseSum1.append(1).append(9).append(6).append(1);
        // 9256 + 46 = 9302
        LinkedListNode<Integer> reverseSum2 = new LinkedListNode<>(2);
        reverseSum2.append(0).append(3).append(9);
        return Stream.of(
                Arguments.of(reverseSum1, addend1, addend2),
                Arguments.of(reverseSum2, addend1, addend3)
        );
    }

    /**
     * @return Test arguments
     */
    private static Stream<Arguments> getParametersForwardOrderSum() {
        // 6529
        LinkedListNode<Integer> addend1 = new LinkedListNode<>(6);
        addend1.append(5).append(2).append(9);
        // 8567
        LinkedListNode<Integer> addend2 = new LinkedListNode<>(8);
        addend2.append(5).append(6).append(7);
        // 64
        LinkedListNode<Integer> addend3 = new LinkedListNode<>(6);
        addend3.append(4);
        // 6529+8567=15096
        LinkedListNode<Integer> forwardSum1 = new LinkedListNode<>(1);
        forwardSum1.append(5).append(0).append(9).append(6);
        // 6529 + 64 = 6593
        LinkedListNode<Integer> forwardSum2 = new LinkedListNode<>(6);
        forwardSum2.append(5).append(9).append(3);
        return Stream.of(
                Arguments.of(forwardSum1, addend1, addend2),
                Arguments.of(forwardSum2, addend1, addend3)
        );
    }
}
