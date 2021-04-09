package utils;
import static utils.Colors.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Timer {

    private final Runnable before;
    private final Runnable after;
    private final String problem;

    /**
     * Timer to time two runnable objects and give the timing difference.
     * @param   problem The problem index.
     * @param   before The solution before reading the hints.
     * @param   after The solution after reading the hints.
     */
    public Timer(String problem, Runnable before, Runnable after) {
        this.problem = problem;
        this.before = before;
        this.after = after;
    }

    /**
     * Start timing.
     */
    public void start() {
        long beforeTime = time(this.before);
        long afterTime = time(this.after);

        printBlue(this.problem);
        if (beforeTime > afterTime) {
            printGreen("The solution after reading the solution is " + (beforeTime - afterTime) + " ns faster.");
        } else if (beforeTime < afterTime) {
            printRed("The solution after reading the solution is " + (afterTime - beforeTime) + " ns slower.");
        } else {
            System.out.println("The solution after reading the solution is as fast as before.");
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
