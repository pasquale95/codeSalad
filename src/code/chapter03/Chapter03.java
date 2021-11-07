package chapter03;

import utils.ChapterTemplate;
import utils.SolutionTemplate;
import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class Chapter03 extends ChapterTemplate {
    protected static ArrayList<SolutionTemplate> exercises;

    public Chapter03() {
        exercises = new ArrayList<>();
        exercises.add(new chapter03.ex3_1.Solution());
        exercises.add(new chapter03.ex3_2.Solution());
        exercises.add(new chapter03.ex3_3.Solution());
        exercises.add(new chapter03.ex3_4.Solution());
        exercises.add(new chapter03.ex3_5.Solution());
    }

    @Override
    protected ArrayList<SolutionTemplate> getExercises() {
        return exercises;
    }
}
