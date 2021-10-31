package utils;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class ChapterTemplate {

    public void runSolutions() {
        for (SolutionTemplate sol : getExercises()) {
            sol.solve();
        }
    }

    public void timeSolutions(ConfigManager configManager) {
        for (SolutionTemplate sol : getExercises()) {
            String[] codes = sol.getClass().getPackageName().split("\\.");
            sol.time(configManager.getConfig(codes[0], codes[1]));
        }
    }

    protected abstract ArrayList<SolutionTemplate> getExercises();
}
