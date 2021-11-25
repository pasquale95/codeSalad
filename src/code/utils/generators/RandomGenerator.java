package utils.generators;

import org.json.simple.JSONObject;

import java.util.Random;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
public class RandomGenerator {

    /**
     * @param   params Set of parameters to use for generating a random integer.
     * @return  A random integer.
     */
    public static Integer randomIntegerGenerator(JSONObject params) {
        return randomIntegerGenerator(((Long) params.get("ceiling")).intValue());
    }

    /**
     * @param   params Set of parameters to use for generating a random integer.
     * @return  A random char.
     */
    public static Character randomCharGenerator(JSONObject params) {
        return randomCharGenerator(((Boolean) params.get("onlyLowerCase")));
    }

    /**
     * @return  A random boolean.
     */
    public static Boolean randomBooleanGenerator() {
        return randomIntegerGenerator(2) == 1;
    }

    /**
     * @param   onlyLowerCase True if the string can only contain lowercase alphabet chars (no space).
     * @return  A random char.
     */
    public static Character randomCharGenerator(Boolean onlyLowerCase) {
        char[] lowerAlphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] lowerUpperAlphabetWithSpace = "abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (onlyLowerCase) {
            return lowerAlphabet[randomIntegerGenerator(lowerAlphabet.length)];
        } else {
            return lowerUpperAlphabetWithSpace[randomIntegerGenerator(lowerUpperAlphabetWithSpace.length)];
        }
    }

    /**
     * @param   ceiling The upper bound number for the random generator.
     * @return  A random number.
     */
    public static Integer randomIntegerGenerator(Integer ceiling) {
        Random r = new Random();
        return r.nextInt(ceiling);
    }
}
