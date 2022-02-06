package chapter02;

import utils.architecture.ChapterTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Chapter02 extends ChapterTemplate {
    public Chapter02() {
        comparators.add(new chapter02.ex2_1.Comparator());
        comparators.add(new chapter02.ex2_2.Comparator());
        comparators.add(new chapter02.ex2_3.Comparator());
        comparators.add(new chapter02.ex2_4.Comparator());
        comparators.add(new chapter02.ex2_5.Comparator());
        comparators.add(new chapter02.ex2_6.Comparator());
    }
}
