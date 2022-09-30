package com.knubisoft.tasks.algorithm.luckyticket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LuckyTicketTest {

    private final LuckyTicket instance = new LuckyTicketImpl();


    @ParameterizedTest
    @ValueSource(strings = {"131asd", "null", "1", "123432", "-555555", "abCd"})
    void isOdd_ShouldReturnTrueForOddNumbers(String ticket) {
        assertFalse(instance.checkIsLuckyTicket(ticket));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String ticket) {
        assertFalse(instance.checkIsLuckyTicket(ticket));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String ticket) {
        assertFalse(instance.checkIsLuckyTicket(ticket));
    }

    @Test
    public void luckyTicketsTest() {
        assertTrue(instance.checkIsLuckyTicket("123321"));
        assertTrue(instance.checkIsLuckyTicket("123321"));
        assertTrue(instance.checkIsLuckyTicket("1234321"));
        assertTrue(instance.checkIsLuckyTicket("2345432"));
        assertTrue(instance.checkIsLuckyTicket("23455432"));
        assertTrue(instance.checkIsLuckyTicket("0000000"));
    }

    @Test
    public void notLuckyTicketsTest() {
        assertFalse(instance.checkIsLuckyTicket(null));
        assertFalse(instance.checkIsLuckyTicket(""));
        assertFalse(instance.checkIsLuckyTicket("null"));
        assertFalse(instance.checkIsLuckyTicket("abCd"));
        assertFalse(instance.checkIsLuckyTicket("1"));
        assertFalse(instance.checkIsLuckyTicket("null"));
        assertFalse(instance.checkIsLuckyTicket("131asd"));
        assertFalse(instance.checkIsLuckyTicket("123432"));
        assertFalse(instance.checkIsLuckyTicket("555455"));
        assertFalse(instance.checkIsLuckyTicket("6666666666"));
        assertFalse(instance.checkIsLuckyTicket("-555555"));
        assertFalse(instance.checkIsLuckyTicket("131asd131asd131asd131asd131asd....!@#$%^&*()"));
    }
}