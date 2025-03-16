package com.brbank.ms_credit_card.domain.enums;

public enum CreditCardStatusEnum {
    ALLOWED,
    BLOCKED,
    CANCELLED;

    public static CreditCardStatusEnum fromString(String status) {
        for (CreditCardStatusEnum creditCardStatusEnum : CreditCardStatusEnum.values()) {
            if (creditCardStatusEnum.name().equalsIgnoreCase(status)) {
                return creditCardStatusEnum;
            }
        }
        return null;
    }
}
