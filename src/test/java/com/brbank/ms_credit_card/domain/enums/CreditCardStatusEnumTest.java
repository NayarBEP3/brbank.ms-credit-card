package com.brbank.ms_credit_card.domain.enums;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditCardStatusEnumTest {

    @Test
    void testFromString() {
        final var creditCardStatusEnumAllowed = CreditCardStatusEnum.fromString("ALLOWED");
        final var creditCardStatusEnumBlocked = CreditCardStatusEnum.fromString("BLOCKED");
        final var creditCardStatusEnumCancelled = CreditCardStatusEnum.fromString("CANCELLED");
        Assertions.assertEquals(CreditCardStatusEnum.ALLOWED, creditCardStatusEnumAllowed);
        Assertions.assertEquals(CreditCardStatusEnum.BLOCKED, creditCardStatusEnumBlocked);
        Assertions.assertEquals(CreditCardStatusEnum.CANCELLED, creditCardStatusEnumCancelled);
    }

    @Test
    void testFromStringNull() {
        final var creditCardStatusEnum = CreditCardStatusEnum.fromString("INVALID");
        Assertions.assertNull(creditCardStatusEnum);
    }
}
