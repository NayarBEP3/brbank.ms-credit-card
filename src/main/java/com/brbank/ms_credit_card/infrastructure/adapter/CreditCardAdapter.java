package com.brbank.ms_credit_card.infrastructure.adapter;

import com.brbank.ms_credit_card.domain.port.CreateCreditCardUseCase;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.application.mapper.CreditCardMapper;
import com.brbank.ms_credit_card.infrastructure.persistance.repository.CreditCardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardAdapter implements CreateCreditCardUseCase {

    private final CreditCardJpaRepository creditCardJpaRepository;

    @Override
    public CreditCardModel createCreditCard(final CreditCardModel creditCardModel) {
        var creditCardEntity = CreditCardMapper.INSTANCE.fromModelToEntity(creditCardModel);
        creditCardEntity = this.creditCardJpaRepository.save(creditCardEntity);
        return CreditCardMapper.INSTANCE.fromEntityToModel(creditCardEntity);
    }

}
