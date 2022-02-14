package chapter03.ex3_4.post;

import chapter03.ex3_4.MyQueueStrategy;
import chapter03.ex3_4.SolutionTemplate;
import utils.exceptions.EmptyQueueException;
import utils.Stack;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    public Solution(Integer[] numbers, Boolean[] remove) {
        super(numbers, remove);
    }

    @Override
    public MyQueueStrategy getMyQueueInstance() {
        return new MyQueue();
    }
}