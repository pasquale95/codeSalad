package chapter03;

import utils.architecture.ChapterTemplate;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Chapter03 extends ChapterTemplate {
    public Chapter03() {
        comparators.add(new chapter03.ex3_1.Comparator());
        comparators.add(new chapter03.ex3_2.Comparator());
        comparators.add(new chapter03.ex3_3.Comparator());
        comparators.add(new chapter03.ex3_4.Comparator());
        comparators.add(new chapter03.ex3_5.Comparator());
    }
}
