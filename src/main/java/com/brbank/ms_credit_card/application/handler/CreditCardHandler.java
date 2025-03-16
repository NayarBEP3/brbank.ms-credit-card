package com.brbank.ms_credit_card.application.handler;

import com.brbank.ms_credit_card.application.mapper.CreditCardMapper;
import com.brbank.ms_credit_card.domain.service.CreditCardService;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreateCreditCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardHandler {

    private final CreditCardService creditCardService;

    public CreateCreditCardResponse createCreditCard(final CreateCreditCardRequest createCreditCardRequest) {
        final var creditCardModel = CreditCardMapper.INSTANCE.fromRequestToModel(createCreditCardRequest);
        final var creditCardModelResp = this.creditCardService.createCreditCard(creditCardModel);
        return CreditCardMapper.INSTANCE.fromModelToResponse(creditCardModelResp);
    }

}
