package org.hbrs.se1.ws21.uebung1.control;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    GermanTranslator germanTranslator;

    @BeforeEach
    void setUp() {
        germanTranslator = new GermanTranslator();
    }

    @AfterEach
    void tearDown() {
        germanTranslator = null;
    }

    @Test
    void translateNumber() {
        assertEquals("zwei", germanTranslator.translateNumber(2));
    }
}