package utils.architecture;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class ChapterTemplate {
    protected ArrayList<ComparatorTemplate> comparators = new ArrayList<>();

    public void runPreSolutions() throws Exception {
        for (ComparatorTemplate comparator : comparators) {
            comparator.getProblem().solutionPre();
        }
    }

    public void runPostSolutions() throws Exception {
        for (ComparatorTemplate comparator : comparators) {
            comparator.getProblem().solutionPost();
        }
    }

    public void timeSolutions(ConfigManager configManager) {
        for (ComparatorTemplate comparator : comparators) {
            String[] codes = comparator.getClass().getPackageName().split("\\.");
            comparator.time(configManager.getConfig(codes[0], codes[1]));
        }
    }
}
