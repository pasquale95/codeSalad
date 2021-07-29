package chapter01;

import org.json.simple.JSONObject;
import utils.Configurator;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Main {

    public static final String CHAPTER_CODE = "chapter01";

    public static void main(String[] args) {
        //runSolutions();
        //timeSolutions();
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
        chapter01.ex1_6.Solution.main(null);
        chapter01.ex1_7.Solution.main(null);
    }

    /**
     * Time all solutions for chapter 1
     */
    public static void timeSolutions(Configurator configurator) {
        chapter01.ex1_1.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_1"));
        chapter01.ex1_2.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_2"));
        chapter01.ex1_3.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_3"));
        chapter01.ex1_4.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_4"));
        chapter01.ex1_5.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_5"));
        chapter01.ex1_6.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_6"));
        chapter01.ex1_7.Solution.time(configurator.getConfig(CHAPTER_CODE, "ex1_7"));
    }
}
