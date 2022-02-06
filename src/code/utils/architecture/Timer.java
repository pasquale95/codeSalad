package utils.architecture;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Timer {

    private final Runnable pre;
    private final Runnable post;
    private final String problem;

    /**
     * Timer to time two runnable objects and give the timing difference.
     * @param   problem The problem index.
     * @param   pre The solution before reading the hints.
     * @param   post The solution after reading the hints.
     */
    public Timer(String problem, Runnable pre, Runnable post) {
        this.problem = problem;
        this.pre = pre;
        this.post = post;
    }

    /**
     * Start timing.
     */
    public void start() {
        long preTime = time(this.pre);
        long postTime = time(this.post);

        printBlue(this.problem);
        if (preTime > postTime) {
            printGreen("The solution after reading the solution is " + (preTime - postTime) + " ns faster.");
        } else if (preTime < postTime) {
            printRed("The solution after reading the solution is " + (postTime - preTime) + " ns slower.");
        } else {
            System.out.println("The solution after reading the solution is as fast as the one defined before.");
        }
    }

    /**
     * Time a runnable instance.
     * @param   runnable The runnable instance to time.
     * @return  The time required to complete.
     */
    public static long time(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
