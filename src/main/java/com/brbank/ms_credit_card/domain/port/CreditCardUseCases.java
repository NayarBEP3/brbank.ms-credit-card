package com.brbank.ms_credit_card.domain.port;

import com.brbank.ms_credit_card.domain.model.CreditCardModel;

import java.util.List;

public interface CreditCardUseCases {

    CreditCardModel createCreditCard(CreditCardModel creditCardModel);
    List<CreditCardModel> getAllCreditCards();

}
