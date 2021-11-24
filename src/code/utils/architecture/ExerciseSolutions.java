package utils.architecture;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class ExerciseSolutions {

    private final Runnable before, after;

    /**
     * Wrapper class containing the two solutions for a given exercise.
     * @param   before The solution created before reading the book.
     * @param   after The solution created after reading the book.
     */
    public ExerciseSolutions(Runnable before, Runnable after) {
        this.before = before;
        this.after = after;
    }

    public Runnable getBefore() {
        return before;
    }

    public Runnable getAfter() {
        return after;
    }
}
