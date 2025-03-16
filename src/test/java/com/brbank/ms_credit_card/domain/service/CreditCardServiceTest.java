package com.brbank.ms_credit_card.domain.service;

import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.domain.port.CreditCardUseCases;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditCardServiceTest {

    @Mock
    private CreditCardUseCases creditCardUseCases;
    @InjectMocks
    private CreditCardService creditCardService;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createCreditCardOk() {
        final var creditCardModel = new CreditCardModel();
        creditCardModel.setCreditCardId(1L);
        creditCardModel.setCreditCardCvc("123");
        creditCardModel.setCreditCardNumber("123321");
        creditCardModel.setHolderName("Brayan Estrada");
        creditCardModel.setMonthValidThru("12");
        creditCardModel.setYearValidThru("27");
        Mockito.when(this.creditCardUseCases.createCreditCard(ArgumentMatchers.any())).thenReturn(creditCardModel);

        final var response = this.creditCardService.createCreditCard(creditCardModel);

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
    }

    @Test
    void getAllCreditCardsOk() {
        final var creditCardModel = new CreditCardModel();
        creditCardModel.setCreditCardId(1L);
        creditCardModel.setCreditCardCvc("123");
        creditCardModel.setCreditCardNumber("123321");
        creditCardModel.setHolderName("Brayan Estrada");
        creditCardModel.setMonthValidThru("12");
        creditCardModel.setYearValidThru("27");
        Mockito.when(this.creditCardUseCases.getAllCreditCards()).thenReturn(List.of(creditCardModel));

        final var response = this.creditCardService.getAllCreditCards();

        Assertions.assertEquals(1L, response.getFirst().getCreditCardId());
        Assertions.assertEquals("123", response.getFirst().getCreditCardCvc());
        Assertions.assertEquals("123321", response.getFirst().getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getFirst().getHolderName());
        Assertions.assertEquals("12", response.getFirst().getMonthValidThru());
        Assertions.assertEquals("27", response.getFirst().getYearValidThru());
    }

    @Test
    void changeCreditCardStatusOK() {
        final var creditCardModelResponse = new CreditCardModel();
        creditCardModelResponse.setCreditCardId(1L);
        creditCardModelResponse.setCreditCardCvc("123");
        creditCardModelResponse.setCreditCardNumber("123321");
        creditCardModelResponse.setHolderName("Brayan Estrada");
        creditCardModelResponse.setMonthValidThru("12");
        creditCardModelResponse.setYearValidThru("27");
        Mockito.when(this.creditCardUseCases.changeCreditCardStatus(ArgumentMatchers.anyString(), ArgumentMatchers.any(CreditCardStatusEnum.class)))
                .thenReturn(creditCardModelResponse);

        final var response = this.creditCardService.changeCreditCardStatus("123321", "ALLOWED");

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
    }
}
