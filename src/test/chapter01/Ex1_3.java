package chapter01;

import chapter01.ex1_3.After;
import chapter01.ex1_3.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static utils.generators.StringGenerator.toCharsWithExtraRoom;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_3 {

    @Test
    @Order(1)
    void urlifyBefore() {
        assertEquals("Mr%20John%20Smith", Before.urlify(toCharsWithExtraRoom("Mr John Smith"), 13));
        assertEquals("%20Mr%20", Before.urlify(toCharsWithExtraRoom(" Mr "), 4));
        assertEquals("%20%20%20%20%20", Before.urlify(toCharsWithExtraRoom("     "), 5));
        assertEquals("", Before.urlify(toCharsWithExtraRoom(""), 0));
    }

    @Test
    @Order(2)
    void urlifyAfter() {
        assertEquals("Mr%20John%20Smith", After.urlify(toCharsWithExtraRoom("Mr John Smith"), 13));
        assertEquals("%20Mr%20", After.urlify(toCharsWithExtraRoom(" Mr "), 4));
        assertEquals("%20%20%20%20%20", After.urlify(toCharsWithExtraRoom("     "), 5));
        assertEquals("", After.urlify(toCharsWithExtraRoom(""), 0));
    }
}