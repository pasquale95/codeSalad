package chapter03;

import chapter03.ex3_1.pre.Solution;
import utils.exceptions.EmptyStackException;
import utils.exceptions.StackOverflowException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Ex3_1 {

    public static final int STACK_ONE = 0, STACK_TWO = 1, STACK_THREE = 2;
    public static final int[] numbers = {1, 3, 5, 6, 10, 13};
    public static final int[] stackSequence = {STACK_ONE, STACK_ONE, STACK_TWO, STACK_THREE, STACK_THREE, STACK_THREE};

    @Test
    @Order(1)
    void threeInOneBefore() throws StackOverflowException, EmptyStackException {
        Solution.allocateStack(6);
        for (int i = 0; i < numbers.length; i++) {
            Solution.pushToStack(numbers[i], stackSequence[i]);
        }
        assertEquals(3, Solution.popFromStack(STACK_ONE));
        assertEquals(5, Solution.popFromStack(STACK_TWO));
        assertEquals(1, Solution.popFromStack(STACK_ONE));
        assertThrows(EmptyStackException.class, () -> Solution.popFromStack(STACK_TWO));
        Solution.pushToStack(20, STACK_ONE);
        Solution.pushToStack(22, STACK_TWO);
        Solution.pushToStack(24, STACK_TWO);
        assertThrows(StackOverflowException.class, () -> Solution.pushToStack(1, STACK_ONE));
        assertEquals(13, Solution.popFromStack(STACK_THREE));
        assertEquals(20, Solution.popFromStack(STACK_ONE));
    }

    @Test
    @Order(2)
    void threeInOneAfter() throws StackOverflowException, EmptyStackException {
        chapter03.ex3_1.post.Solution.allocateStack(6);
        for (int i = 0; i < numbers.length; i++) {
            chapter03.ex3_1.post.Solution.pushToStack(numbers[i], stackSequence[i]);
        }
        assertEquals(3, chapter03.ex3_1.post.Solution.popFromStack(STACK_ONE));
        assertEquals(5, chapter03.ex3_1.post.Solution.popFromStack(STACK_TWO));
        assertEquals(1, chapter03.ex3_1.post.Solution.popFromStack(STACK_ONE));
        assertThrows(EmptyStackException.class, () -> chapter03.ex3_1.post.Solution.popFromStack(STACK_TWO));
        chapter03.ex3_1.post.Solution.pushToStack(20, STACK_ONE);
        chapter03.ex3_1.post.Solution.pushToStack(22, STACK_TWO);
        chapter03.ex3_1.post.Solution.pushToStack(24, STACK_TWO);
        assertThrows(StackOverflowException.class, () -> chapter03.ex3_1.post.Solution.pushToStack(1, STACK_ONE));
        assertEquals(13, chapter03.ex3_1.post.Solution.popFromStack(STACK_THREE));
        assertEquals(20, chapter03.ex3_1.post.Solution.popFromStack(STACK_ONE));
    }
}
