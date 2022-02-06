package chapter01;

import utils.architecture.ChapterTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Chapter01 extends ChapterTemplate {
    public Chapter01() {
        comparators.add(new chapter01.ex1_1.Comparator());
        comparators.add(new chapter01.ex1_2.Comparator());
        comparators.add(new chapter01.ex1_3.Comparator());
        comparators.add(new chapter01.ex1_4.Comparator());
        comparators.add(new chapter01.ex1_5.Comparator());
        comparators.add(new chapter01.ex1_6.Comparator());
        comparators.add(new chapter01.ex1_7.Comparator());
    }
}
