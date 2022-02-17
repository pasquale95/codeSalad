package chapter03.ex3_4.pre;

import chapter03.ex3_4.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(Integer[], Boolean[])
     */
    public Solution(Integer[] numbers, Boolean[] remove) {
        super(numbers, remove);
    }

    @Override
    public MyQueue getMyQueueInstance() {
        return new MyQueue();
    }
}