public class QuestionB {

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
     * # Constraint 1: the input string can be modified.
     *
     * @param stringToCheck
     * @return boolean
     */
    public static boolean isUniqueCharsAfter(String stringToCheck) {
        stringToCheck = stringToCheck.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        for (int i = 0; i < stringToCheck.length()-1; i++) {
            if (stringToCheck.charAt(i) == stringToCheck.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }
}