package com.brbank.ms_credit_card.infrastructure.controller;

import com.brbank.ms_credit_card.application.handler.CreditCardHandler;
import com.brbank.ms_credit_card.infrastructure.dto.request.ChangeCreditCardStatusRequest;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreditCardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CreditCardController {

    private final CreditCardHandler creditCardHandler;

    @PostMapping("/credit-card")
    public CreditCardResponse createCreditCard(@RequestBody final CreateCreditCardRequest request) {
        return creditCardHandler.createCreditCard(request);
    }

    @GetMapping("/credit-card")
    public List<CreditCardResponse> getAllCreditCards() {
        return creditCardHandler.getAllCreditCards();
    }

    @PutMapping("/credit-card/status")
    public CreditCardResponse changeCreditCardStatus(@RequestBody final ChangeCreditCardStatusRequest changeCreditCardStatusRequest) {
        return creditCardHandler.changeCreditCardStatus(changeCreditCardStatusRequest);
    }
}
