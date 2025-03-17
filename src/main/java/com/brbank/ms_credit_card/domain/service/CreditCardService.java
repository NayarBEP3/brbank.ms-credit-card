package com.brbank.ms_credit_card.domain.service;

import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.exception.NotFoundException;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import com.brbank.ms_credit_card.infrastructure.persistance.entity.CreditCardEntity;
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

    public boolean validateCreditCard(final CreditCardModel creditCardModelActual) {
        try {
            final var creditCardExpected = this.creditCardUseCases.validateCreditCard(creditCardModelActual.getCreditCardNumber());
            validateCreditCardStatus(creditCardExpected);
            validateHolderName(creditCardModelActual.getHolderName(), creditCardExpected.getHolderName());
            validateValidThru(creditCardExpected, creditCardModelActual);
            validateCvc(creditCardModelActual.getCreditCardCvc(), creditCardExpected.getCreditCardCvc());
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }



    private void validateCreditCardStatus(final CreditCardModel creditCardEntity) {
        if(!CreditCardStatusEnum.ALLOWED.equals(creditCardEntity.getCreditCardStatus())) {
            throw new NotFoundException("Credit card status not found");
        }
    }

    private void validateCvc(final String cvcExpected, final String cvcActual) {
        if(!cvcExpected.equals(cvcActual)) {
            throw new NotFoundException("CVC not found");
        }
    }

    private void validateHolderName(final String holderNameExpected, final String holderNameActual) {
        if(!holderNameExpected.equals(holderNameActual)) {
            throw new NotFoundException("Holder name not found");
        }
    }

    private void validateValidThru(final CreditCardModel creditCardExpected, final CreditCardModel creditCardActual) {
        if(!creditCardExpected.getMonthValidThru().equals(creditCardActual.getMonthValidThru())
                || !creditCardExpected.getYearValidThru().equals(creditCardActual.getYearValidThru())) {
            throw new NotFoundException("Valid thru not found");
        }
    }

}
