package utils.architecture;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class ChapterTemplate {
    protected final ArrayList<ComparatorTemplate> comparators = new ArrayList<>();

    public void runPreSolutions(ConfigManager configManager) {
        for (ComparatorTemplate comparator : comparators) {
            String[] codes = comparator.getClass().getPackageName().split("\\.");
            comparator.getExerciseSolutions(configManager.getConfig(codes[0], codes[1])).getPre().runSampleSolution();
        }
    }

    public void runPostSolutions(ConfigManager configManager) {
        for (ComparatorTemplate comparator : comparators) {
            String[] codes = comparator.getClass().getPackageName().split("\\.");
            comparator.getExerciseSolutions(configManager.getConfig(codes[0], codes[1])).getPost().runSampleSolution();
        }
    }

    public void timeSolutions(ConfigManager configManager) {
        for (ComparatorTemplate comparator : comparators) {
            String[] codes = comparator.getClass().getPackageName().split("\\.");
            comparator.time(configManager.getConfig(codes[0], codes[1]));
        }
    }
}
