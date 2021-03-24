package utils;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Timer {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private final Runnable before;
    private final Runnable after;
    private final String problem;

    public Timer(String problem, Runnable before, Runnable after) {
        this.problem = problem;
        this.before = before;
        this.after = after;
    }

    public void start() {
        long beforeTime = time(this.before);
        long afterTime = time(this.after);

        System.out.println(ANSI_BLUE + this.problem + ANSI_RESET);
        if (beforeTime > afterTime) {
            System.out.println(ANSI_GREEN + "The solution after reading is " + (beforeTime - afterTime) + " ns faster." + ANSI_RESET);
        } else if (beforeTime < afterTime) {
            System.out.println(ANSI_RED + "The solution after reading is " + (afterTime - beforeTime) + " ns slower." + ANSI_RESET);
        } else {
            System.out.println("The solution after reading is as fast as before.");
        }
    }

    public static long time(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
