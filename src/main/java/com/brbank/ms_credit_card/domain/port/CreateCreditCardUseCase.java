package com.brbank.ms_credit_card.domain.port;

import com.brbank.ms_credit_card.domain.model.CreditCardModel;

public interface CreateCreditCardUseCase {

    CreditCardModel createCreditCard(CreditCardModel creditCardModel);

}
