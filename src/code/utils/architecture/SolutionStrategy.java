package utils.architecture;

public interface SolutionStrategy extends Runnable {

    /**
     * The class implementation must define the solution without reading the tips and the official solution.
     */
    void runSampleSolution();

    /**
     * @return The problem name.
     */
    String getProblemName();
}
