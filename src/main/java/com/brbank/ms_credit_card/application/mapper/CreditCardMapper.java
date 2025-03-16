package com.brbank.ms_credit_card.application.mapper;

import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreateCreditCardResponse;
import com.brbank.ms_credit_card.infrastructure.persistance.entity.CreditCardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {
    CreditCardMapper INSTANCE = Mappers.getMapper(CreditCardMapper.class);

    CreditCardModel fromRequestToModel(CreateCreditCardRequest createCreditCardRequest);
    CreditCardEntity fromModelToEntity(CreditCardModel creditCardModel);
    CreditCardModel fromEntityToModel(CreditCardEntity creditCardEntity);
    CreateCreditCardResponse fromModelToResponse(CreditCardModel creditCardModel);
}
