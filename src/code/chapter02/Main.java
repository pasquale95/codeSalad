package chapter02;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static void main(String[] args) {
        //runSolutions();
        timeSolutions();
    }

    /**
     * Run all solutions for chapter 2
     */
    public static void runSolutions() {
        chapter02.ex2_1.Solution.main(null);
        chapter02.ex2_2.Solution.main(null);
        chapter02.ex2_3.Solution.main(null);
        chapter02.ex2_4.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 2
     */
    public static void timeSolutions() {
        chapter02.ex2_1.Solution.time();
        chapter02.ex2_2.Solution.time();
        chapter02.ex2_3.Solution.time();
        chapter02.ex2_4.Solution.time();
    }
}
