package chapter02.ex2_4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.LinkedListNode;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@Tag("Before")
@DisplayName("Ex2.4: Partition (Before)")
public class TestBefore {

    @ParameterizedTest(name = "Partitioning \"{1}\" on threshold = \"{0}\":")
    @MethodSource("chapter02.ex2_4.TestUtils#getParameters")
    void check(Integer threshold, LinkedListNode<Integer> input) {
        LinkedListNode<Integer> partitioned = Before.partition(input, threshold);
        boolean rightHalf = false;
        LinkedListNode<Integer> runner = partitioned;
        while (runner != null) {
            if (runner.getData() > threshold) {
                rightHalf = true;
            }
            if (!rightHalf) {
                assertTrue(runner.getData() < threshold);
            } else {
                assertFalse(runner.getData() < threshold);
            }
            runner = runner.getNext();
        }
    }
}
