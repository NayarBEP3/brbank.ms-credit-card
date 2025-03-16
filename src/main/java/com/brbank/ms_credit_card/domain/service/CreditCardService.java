package com.brbank.ms_credit_card.domain.service;

import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardUseCases creditCardUseCases;

    public CreditCardModel createCreditCard(final CreditCardModel creditCardModel) {
        return this.creditCardUseCases.createCreditCard(creditCardModel);
    }

    public List<CreditCardModel> getAllCreditCards() {
        return this.creditCardUseCases.getAllCreditCards();
    }

    public CreditCardModel changeCreditCardStatus(final String creditCardModel, final String creditCardStatus) {
        final var statusEnumValue = CreditCardStatusEnum.fromString(creditCardStatus);
        Objects.requireNonNull(statusEnumValue, "Error: Credit card status not found");
        return this.creditCardUseCases.changeCreditCardStatus(creditCardModel, statusEnumValue);
    }

}
