package chapter03;

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
     * Run all solutions for chapter 3
     */
    public static void runSolutions() {
        chapter03.ex3_1.Solution.main(null);
        chapter03.ex3_2.Solution.main(null);
        chapter03.ex3_3.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 3
     */
    public static void timeSolutions() {
        chapter03.ex3_1.Solution.time();
        chapter03.ex3_2.Solution.time();
        chapter03.ex3_3.Solution.time();
    }
}
