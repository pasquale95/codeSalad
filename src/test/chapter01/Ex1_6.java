package chapter01;

import chapter01.ex1_6.After;
import chapter01.ex1_6.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_6 {

    private static final String BIGGER_THAN_COMPRESSION = "aaabbbcddaaAAAAAZZZ";
    private static final String BIGGER_COMPRESSED = "a3b3c1d2a2A5Z3";
    private static final String EQUAL_LENGTH_COMPRESSION = "aaSSccddEfff";
    private static final String SMALLER_THAN_COMPRESSION = "qwertyuiop";

    @Test
    @Order(1)
    void areOneAwayBefore() {
        assertEquals(BIGGER_COMPRESSED, Before.compress(BIGGER_THAN_COMPRESSION));
        assertEquals(EQUAL_LENGTH_COMPRESSION, Before.compress(EQUAL_LENGTH_COMPRESSION));
        assertEquals(SMALLER_THAN_COMPRESSION, Before.compress(SMALLER_THAN_COMPRESSION));
    }

    @Test
    @Order(2)
    void areOneAwayAfter() {
        assertEquals(BIGGER_COMPRESSED, Before.compress(BIGGER_THAN_COMPRESSION));
        assertEquals(EQUAL_LENGTH_COMPRESSION, Before.compress(EQUAL_LENGTH_COMPRESSION));
        assertEquals(SMALLER_THAN_COMPRESSION, Before.compress(SMALLER_THAN_COMPRESSION));
    }
}