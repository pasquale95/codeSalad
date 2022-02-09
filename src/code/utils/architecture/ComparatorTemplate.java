package utils.architecture;

import org.json.simple.JSONObject;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public abstract class ComparatorTemplate {

    /**
     * @return The two solutions for the given exercise.
     */
    protected abstract ExerciseSolutions getExerciseSolutions(JSONObject params);

    /**
     * Start the timer with the two threads, using the stress configs passed as parameter.
     * @param   params The stress configuration settings.
     */
    public void time(JSONObject params) {
        ExerciseSolutions solutions = getExerciseSolutions(params);
        Timer timer = new Timer(solutions.getPre().getProblemName(), solutions.getPre(), solutions.getPost());
        timer.start();
    }
}
