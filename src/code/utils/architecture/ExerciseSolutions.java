package utils.architecture;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class ExerciseSolutions {

    private final Runnable pre, post;

    /**
     * Wrapper class containing the two solutions for a given exercise.
     * @param   pre The solution created before reading the book.
     * @param   post The solution created after reading the book.
     */
    public ExerciseSolutions(Runnable pre, Runnable post) {
        this.pre = pre;
        this.post = post;
    }

    public Runnable getPre() {
        return pre;
    }

    public Runnable getPost() {
        return post;
    }
}
