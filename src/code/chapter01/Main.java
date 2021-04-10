package chapter01;

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
     * Run all solutions for chapter 1
     */
    public static void runSolutions() {
        chapter01.ex1_1.Solution.main(null);
        chapter01.ex1_2.Solution.main(null);
        chapter01.ex1_3.Solution.main(null);
        chapter01.ex1_4.Solution.main(null);
        chapter01.ex1_5.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 1
     */
    public static void timeSolutions() {
        chapter01.ex1_1.Solution.time();
        chapter01.ex1_2.Solution.time();
        chapter01.ex1_3.Solution.time();
        chapter01.ex1_4.Solution.time();
        chapter01.ex1_5.Solution.time();
    }
}
