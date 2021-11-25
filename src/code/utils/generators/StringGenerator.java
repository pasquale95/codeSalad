package utils.generators;

import org.json.simple.JSONObject;

import java.util.function.Supplier;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class StringGenerator {

    /**
     * Generate a string.
     *
     * @param   params Set of parameters to use for generating a string.
     * @param   supplier The supplier function which generates the object Character.
     * @return  Array of random generated strings.
     */
    public static String generateString(
            JSONObject params,
            Supplier<Character> supplier
    ) {
        return generateString(
                ((Long) params.get("stringSize")).intValue(),
                supplier
        );
    }

    /**
     * Generate a string.
     * @param   stringSize Length of the single string inside the pool.
     * @param   supplier The supplier function which generates the object Character.
     * @return  Array of random generated strings.
     */
    public static String generateString(
            int stringSize,
            Supplier<Character> supplier
    ) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringSize; i++) {
            stringBuilder.append(supplier.get());
        }
        return stringBuilder.toString();
    }

    /**
     * Convert the string to a char array with 2 extra cells for each space char inside the string.
     *
     * @param   string The string to convert.
     * @return  Char array with extra space.
     */
    public static char[] toCharsWithExtraRoom(String string) {
        char[] chars = new char[3*string.length()-2*string.replace(" ", "").length()];
        for (int i = 0; i < string.length(); i++) {
            chars[i] = string.charAt(i);
        }
        return chars;
    }
}
