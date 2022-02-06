package utils.architecture;

public abstract class ProblemTemplate {

    /**
     * @return The problem name.
     */
    protected abstract String getProblemName();

    /**
     * The class implementation must define the solution without reading the tips and the official solution.
     */
    public abstract void solutionPre() throws Exception;

    /**
     * The class implementation must define the solution after reading the tips and the official solution.
     */
    public abstract void solutionPost() throws Exception;
}
