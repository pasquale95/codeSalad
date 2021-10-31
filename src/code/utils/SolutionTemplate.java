package utils;

import org.json.simple.JSONObject;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class SolutionTemplate {

    /**
     * The class implementation must define a solving method for the given problem.
     */
    public abstract void solve();

    /**
     * @return The two solutions for the given exercise.
     */
    protected abstract ExerciseSolutions getExerciseSolutions(JSONObject params);

    /**
     * @return The problem name.
     */
    protected abstract String getProblemName();

    /**
     * Start the timer with the two threads, using the stress configs passed as parameter.
     * @param   params The stress configuration settings.
     */
    public void time(JSONObject params) {
        ExerciseSolutions solutions = getExerciseSolutions(params);
        Timer timer = new Timer(this.getProblemName(), solutions.getBefore(), solutions.getAfter());
        timer.start();
    }
}
