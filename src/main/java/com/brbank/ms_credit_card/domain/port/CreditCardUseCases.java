package com.brbank.ms_credit_card.domain.port;

import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;

import java.util.List;

public interface CreditCardUseCases {

    CreditCardModel createCreditCard(final CreditCardModel creditCardModel);
    List<CreditCardModel> getAllCreditCards();
    CreditCardModel changeCreditCardStatus(final String creditCardNumber, final CreditCardStatusEnum creditCardStatus);

}
