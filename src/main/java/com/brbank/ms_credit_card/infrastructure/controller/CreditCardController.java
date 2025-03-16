package com.brbank.ms_credit_card.infrastructure.controller;

import com.brbank.ms_credit_card.application.handler.CreditCardHandler;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreateCreditCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardHandler creditCardHandler;

    @PostMapping("/credit-card")
    public CreateCreditCardResponse createCreditCard(@RequestBody final CreateCreditCardRequest request) {
        return creditCardHandler.createCreditCard(request);
    }
}
