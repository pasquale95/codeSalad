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

    public static Integer randomIntegerGenerator(JSONObject params) {
        return randomIntegerGenerator(((Long) params.get("ceiling")).intValue());
    }

    public static Boolean randomBooleanGenerator() {
        return randomIntegerGenerator(2) == 1;
    }

    public static Integer randomIntegerGenerator(Integer ceiling) {
        Random r = new Random();
        return r.nextInt(ceiling);
    }
}
