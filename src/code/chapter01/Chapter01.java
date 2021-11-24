package chapter01;

import utils.architecture.ChapterTemplate;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Chapter01 extends ChapterTemplate {
    public Chapter01() {
        exercises = new ArrayList<>();
        exercises.add(new chapter01.ex1_1.Solution());
        exercises.add(new chapter01.ex1_2.Solution());
        exercises.add(new chapter01.ex1_3.Solution());
        exercises.add(new chapter01.ex1_4.Solution());
        exercises.add(new chapter01.ex1_5.Solution());
        exercises.add(new chapter01.ex1_6.Solution());
        exercises.add(new chapter01.ex1_7.Solution());
    }
}
