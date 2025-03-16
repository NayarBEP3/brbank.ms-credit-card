package com.brbank.ms_credit_card.infrastructure.adapter;

import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.exception.NotFoundException;
import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.application.mapper.CreditCardMapper;
import com.brbank.ms_credit_card.infrastructure.persistance.repository.CreditCardJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditCardAdapter implements CreditCardUseCases {

    private final CreditCardJpaRepository creditCardJpaRepository;

    @Override
    public CreditCardModel createCreditCard(final CreditCardModel creditCardModel) {
        var creditCardEntity = CreditCardMapper.INSTANCE.fromModelToEntity(creditCardModel);
        creditCardEntity = this.creditCardJpaRepository.save(creditCardEntity);
        return CreditCardMapper.INSTANCE.fromEntityToModel(creditCardEntity);
    }

    @Override
    public List<CreditCardModel> getAllCreditCards() {
        final var creditCardEntityList = this.creditCardJpaRepository.findAll();
        if (!creditCardEntityList.isEmpty()) {
            return CreditCardMapper.INSTANCE.fromEntityListToModelList(creditCardEntityList);
        }
        return List.of();
    }

    @Override
    public CreditCardModel changeCreditCardStatus(final String creditCardNumber, final CreditCardStatusEnum creditCardStatus) {
        var creditCardEntity = this.creditCardJpaRepository.findByCreditCardNumber(creditCardNumber)
                .orElseThrow(() -> new NotFoundException("Credit card not found"));
        creditCardEntity.setCreditCardStatus(creditCardStatus);
        creditCardEntity = this.creditCardJpaRepository.save(creditCardEntity);
        return CreditCardMapper.INSTANCE.fromEntityToModel(creditCardEntity);

    }

}
