package chapter03.ex3_3.pre;

import chapter03.ex3_3.SetOfStacksStrategy;
import chapter03.ex3_3.SolutionTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Solution extends SolutionTemplate {

    /**
     * @see SolutionTemplate#SolutionTemplate(Integer[], int)
     */
    public Solution(Integer[] numbers, int threshold) {
        super(numbers, threshold);
    }

    @Override
    public SetOfStacksStrategy getSetOfStacksInstance(int stacks) {
        return new SetOfStacks(stacks);
    }
}