package com.brbank.ms_credit_card.infrastructure.controller;

import com.brbank.ms_credit_card.application.handler.CreditCardHandler;
import com.brbank.ms_credit_card.infrastructure.dto.request.CreateCreditCardRequest;
import com.brbank.ms_credit_card.infrastructure.dto.response.CreditCardResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditCardControllerTest {

    @Mock
    private CreditCardHandler creditCardHandler;
    @InjectMocks
    private CreditCardController creditCardController;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCreditCardOK() {
        final var createCreditCardRequest = new CreateCreditCardRequest();
        createCreditCardRequest.setCreditCardCvc("123");
        createCreditCardRequest.setCreditCardNumber("123321");
        createCreditCardRequest.setHolderName("Brayan Estrada");
        createCreditCardRequest.setMonthValidThru("12");
        createCreditCardRequest.setYearValidThru("27");
        final var creditCardResponse = new CreditCardResponse();
        creditCardResponse.setCreditCardId(1L);
        creditCardResponse.setCreditCardCvc("123");
        creditCardResponse.setCreditCardNumber("123321");
        creditCardResponse.setHolderName("Brayan Estrada");
        creditCardResponse.setMonthValidThru("12");
        creditCardResponse.setYearValidThru("27");
        Mockito.when(this.creditCardHandler.createCreditCard(ArgumentMatchers.any())).thenReturn(creditCardResponse);

        final var response = this.creditCardController.createCreditCard(createCreditCardRequest);

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
    }

    @Test
    void getAllCreditCardsOK() {
        final var creditCardResponse = new CreditCardResponse();
        creditCardResponse.setCreditCardId(1L);
        creditCardResponse.setCreditCardCvc("123");
        creditCardResponse.setCreditCardNumber("123321");
        creditCardResponse.setHolderName("Brayan Estrada");
        creditCardResponse.setMonthValidThru("12");
        creditCardResponse.setYearValidThru("27");
        Mockito.when(this.creditCardHandler.getAllCreditCards()).thenReturn(List.of(creditCardResponse));

        final var response = this.creditCardController.getAllCreditCards();

        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1L, response.getFirst().getCreditCardId());
        Assertions.assertEquals("123", response.getFirst().getCreditCardCvc());
        Assertions.assertEquals("123321", response.getFirst().getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getFirst().getHolderName());
        Assertions.assertEquals("12", response.getFirst().getMonthValidThru());
        Assertions.assertEquals("27", response.getFirst().getYearValidThru());
    }
}
