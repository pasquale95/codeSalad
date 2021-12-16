package chapter02.ex2_6;

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
        LinkedListNode<Integer> palindrome = new LinkedListNode<>(6);
        palindrome.append(5).append(3).append(5).append(6);
        LinkedListNode<Integer> notPalindrome = palindrome.clone();
        notPalindrome.append(7);
        return Stream.of(
                Arguments.of(true, palindrome),
                Arguments.of(false, notPalindrome)
        );
    }
}
