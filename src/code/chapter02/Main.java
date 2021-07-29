package chapter02;

import utils.Configurator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static final String CHAPTER_CODE = "chapter02";

    public static void main(String[] args) {
        //runSolutions();
        //timeSolutions();
    }

    /**
     * Run all solutions for chapter 2
     */
    public static void runSolutions() {
        chapter02.ex2_1.Solution.main(null);
        chapter02.ex2_2.Solution.main(null);
        chapter02.ex2_3.Solution.main(null);
        chapter02.ex2_4.Solution.main(null);
        chapter02.ex2_5.Solution.main(null);
        chapter02.ex2_6.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 2
     */
    public static void timeSolutions(Configurator configurator) {
        chapter02.ex2_1.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_1"));
        chapter02.ex2_2.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_2"));
        chapter02.ex2_3.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_3"));
        chapter02.ex2_4.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_4"));
        chapter02.ex2_5.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_5"));
        chapter02.ex2_6.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex2_6"));
    }
}
