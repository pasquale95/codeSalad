public class Question {

    /**
     * My implementation before reading the solution.
     *
     * @param first
     * @param second
     * @return boolean
     */
    public static boolean arePermutationsBefore(String first, String second) {
        if (first.length() != second.length()) {
            // permutations must have same length
            return false;
        }
        String firstSorted = first.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        String secondSorted = second.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return firstSorted.equals(secondSorted);
    }

    /**
     * My implementation after reading the solution.
     *
     * Constraint 1: we can assume that the string only contains ASCII chars (128 totally).
     *
     * @param first
     * @param second
     * @return boolean
     */
    public static boolean arePermutationsAfter(String first, String second) {
        if (first.length() != second.length()) {
            // permutations must have same length
            return false;
        }
        // if permutations, first should balance the negative balance of the second
        int[] chars = new int[128];
        for (int i = 0; i < first.length(); i++) {
            chars[first.charAt(i)]++;
            chars[second.charAt(i)]--;
        }
        // check occurrences
        for (int characterOccurrence : chars) {
            if (characterOccurrence < 0) {
                return false;
            }
        }
        return true;
    }
}
