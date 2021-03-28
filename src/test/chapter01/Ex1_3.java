package chapter01;

import chapter01.ex1_3.Solution;
import chapter01.ex1_3.After;
import chapter01.ex1_3.Before;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(Before.urlify(Solution.toCharsWithExtraRoom("Mr John Smith"), 13), "Mr%20John%20Smith");
        assertEquals(Before.urlify(Solution.toCharsWithExtraRoom(" Mr "), 4), "%20Mr%20");
        assertEquals(Before.urlify(Solution.toCharsWithExtraRoom("     "), 5), "%20%20%20%20%20");
        assertEquals(Before.urlify(Solution.toCharsWithExtraRoom(""), 0), "");
    }

    @Test
    @Order(2)
    void urlifyAfter() {
        assertEquals(After.urlify(Solution.toCharsWithExtraRoom("Mr John Smith"), 13), "Mr%20John%20Smith");
        assertEquals(After.urlify(Solution.toCharsWithExtraRoom(" Mr "), 4), "%20Mr%20");
        assertEquals(After.urlify(Solution.toCharsWithExtraRoom("     "), 5), "%20%20%20%20%20");
        assertEquals(After.urlify(Solution.toCharsWithExtraRoom(""), 0), "");
    }
}