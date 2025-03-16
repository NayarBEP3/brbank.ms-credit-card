package com.brbank.ms_credit_card.domain.service;

import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.domain.port.CreateCreditCardUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreditCardService {

    private final CreateCreditCardUseCase createCreditCardUseCase;

    public CreditCardModel createCreditCard(final CreditCardModel creditCardModel) {
        return this.createCreditCardUseCase.createCreditCard(creditCardModel);
    }

}
