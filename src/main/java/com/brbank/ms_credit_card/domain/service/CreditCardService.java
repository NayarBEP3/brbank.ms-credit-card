package com.brbank.ms_credit_card.domain.service;

import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CreditCardService {

    private final CreditCardUseCases creditCardUseCases;

    public CreditCardModel createCreditCard(final CreditCardModel creditCardModel) {
        return this.creditCardUseCases.createCreditCard(creditCardModel);
    }

    public List<CreditCardModel> getAllCreditCards() {
        return this.creditCardUseCases.getAllCreditCards();
    }

}
