public class QuestionA {

    /**
     * My implementation before reading the solution.
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsBefore(String stringToCheck) {
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            for (int j = i+1; j < stringToCheck.length(); j++) {
                if (stringToCheck.charAt(i) == stringToCheck.charAt(j)) {
                    // if two chars are equal, return false
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * My implementation after reading the solution.
     * - Constraint 1: just alphabetical characters (numbers don't count);
     * - Constraint 2: uppercase and lowercase chars count for the same;
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsAfter(String stringToCheck) {
        int bitVector = 0;
        String stringToCheckLower = stringToCheck.toLowerCase();
        for (int i = 0; i < stringToCheck.length(); i++) {
            int alphabetPosition = stringToCheckLower.charAt(i) - 'a';
            if ((bitVector & (1 << alphabetPosition)) > 0) {
                // found a character with the same position in the alphabet
                return false;
            }
            // mark that position as taken
            bitVector |= (1 << alphabetPosition);
        }
        return true;
    }
}