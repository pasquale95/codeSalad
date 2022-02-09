package utils.architecture;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class ExerciseSolutions {

    private final SolutionStrategy pre, post;

    /**
     * Wrapper class containing the two solutions for a given exercise.
     * @param   pre The solution created before reading the book.
     * @param   post The solution created after reading the book.
     */
    public ExerciseSolutions(SolutionStrategy pre, SolutionStrategy post) {
        this.pre = pre;
        this.post = post;
    }

    public SolutionStrategy getPre() {
        return pre;
    }

    public SolutionStrategy getPost() {
        return post;
    }
}
