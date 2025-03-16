package com.brbank.ms_credit_card.application.handler;

import com.brbank.ms_credit_card.application.mapper.CreditCardMapper;
import com.brbank.ms_credit_card.domain.service.CreditCardService;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreditCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditCardHandler {

    private final CreditCardService creditCardService;

    public CreditCardResponse createCreditCard(final CreateCreditCardRequest createCreditCardRequest) {
        final var creditCardModel = CreditCardMapper.INSTANCE.fromRequestToModel(createCreditCardRequest);
        final var creditCardModelResp = this.creditCardService.createCreditCard(creditCardModel);
        return CreditCardMapper.INSTANCE.fromModelToResponse(creditCardModelResp);
    }

    public List<CreditCardResponse> getAllCreditCards() {
        final var creditCardModelList = this.creditCardService.getAllCreditCards();
        return CreditCardMapper.INSTANCE.fromModelListToResponseList(creditCardModelList);
    }
}
