package chapter01;

import chapter01.ex1_5.After;
import chapter01.ex1_5.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Pasquale Convertini <pasqualeconvertini95@gmail.com>
 * @github @pasquale95
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this source code package.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Ex1_5 {

    @Test
    @Order(1)
    void oneAwayBefore() {
        assertTrue(Before.areOneAway("pales", "pale"));
        assertTrue(Before.areOneAway("pale", "ple"));
        assertTrue(Before.areOneAway("pale", "bale"));
        assertFalse(Before.areOneAway("pale", "bake"));
        assertFalse(Before.areOneAway("pale", "bales"));
        assertFalse(Before.areOneAway("pale", "bal"));
    }

    @Test
    @Order(2)
    void oneAwayAfter() {
        assertTrue(After.areOneAway("pales", "pale"));
        assertTrue(After.areOneAway("pale", "ple"));
        assertTrue(After.areOneAway("pale", "bale"));
        assertFalse(After.areOneAway("pale", "bake"));
        assertFalse(After.areOneAway("pale", "bales"));
        assertFalse(After.areOneAway("pale", "bal"));
    }
}