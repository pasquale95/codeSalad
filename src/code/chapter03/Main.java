package chapter03;

import utils.Configurator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {
    public static final String CHAPTER_CODE = "chapter03";

    public static void main(String[] args) {
        //runSolutions();
        //timeSolutions();
    }

    /**
     * Run all solutions for chapter 3
     */
    public static void runSolutions() {
        chapter03.ex3_1.Solution.main(null);
        chapter03.ex3_2.Solution.main(null);
        chapter03.ex3_3.Solution.main(null);
        chapter03.ex3_4.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 3
     */
    public static void timeSolutions(Configurator configurator) {
        chapter03.ex3_1.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex3_1"));
        chapter03.ex3_2.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex3_2"));
        chapter03.ex3_3.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex3_3"));
        chapter03.ex3_4.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex3_4"));
    }
}
