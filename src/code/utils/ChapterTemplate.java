package utils;

import java.util.ArrayList;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class ChapterTemplate {
    protected ArrayList<SolutionTemplate> exercises = new ArrayList<>();

    public void runSolutions() {
        for (SolutionTemplate sol : exercises) {
            sol.solve();
        }
    }

    public void timeSolutions(ConfigManager configManager) {
        for (SolutionTemplate sol : exercises) {
            String[] codes = sol.getClass().getPackageName().split("\\.");
            sol.time(configManager.getConfig(codes[0], codes[1]));
        }
    }
}
