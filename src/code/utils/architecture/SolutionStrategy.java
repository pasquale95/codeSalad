package utils.architecture;

public interface SolutionStrategy extends Runnable {

    /**
     * @return The problem name.
     */
    String getProblemName();

    /**
     * The class implementation must define the solution without reading the tips and the official solution.
     */
    void runSampleSolution();
}
