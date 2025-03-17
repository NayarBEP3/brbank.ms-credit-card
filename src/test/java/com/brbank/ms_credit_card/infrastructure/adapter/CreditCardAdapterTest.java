package com.brbank.ms_credit_card.infrastructure.adapter;


import com.brbank.ms_credit_card.domain.enums.CreditCardStatusEnum;
import com.brbank.ms_credit_card.domain.exception.NotFoundException;
import com.brbank.ms_credit_card.domain.model.CreditCardModel;
import com.brbank.ms_credit_card.infrastructure.persistance.entity.CreditCardEntity;
import com.brbank.ms_credit_card.infrastructure.persistance.repository.CreditCardJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditCardAdapterTest {

    @Mock
    private CreditCardJpaRepository creditCardJpaRepository;
    @InjectMocks
    private CreditCardAdapter creditCardAdapter;

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
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        Mockito.when(this.creditCardJpaRepository.save(ArgumentMatchers.any())).thenReturn(creditCardEntity);

        final var response = this.creditCardAdapter.createCreditCard(creditCardModel);

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
    }

    @Test
    void getAllCreditCardsOk() {
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        Mockito.when(this.creditCardJpaRepository.findAll()).thenReturn(List.of(creditCardEntity));

        final var response = this.creditCardAdapter.getAllCreditCards();

        Assertions.assertEquals(1, response.size());
        Assertions.assertEquals(1L, response.getFirst().getCreditCardId());
        Assertions.assertEquals("123", response.getFirst().getCreditCardCvc());
        Assertions.assertEquals("123321", response.getFirst().getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getFirst().getHolderName());
        Assertions.assertEquals("12", response.getFirst().getMonthValidThru());
        Assertions.assertEquals("27", response.getFirst().getYearValidThru());
    }

    @Test
    void emptyCreditCardList() {
        Mockito.when(this.creditCardJpaRepository.findAll()).thenReturn(List.of());

        final var response = this.creditCardAdapter.getAllCreditCards();

        Assertions.assertEquals(0, response.size());
    }

    @Test
    void changeCreditCardStatusOk() {
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        creditCardEntity.setCreditCardStatus(CreditCardStatusEnum.CANCELLED);
        Mockito.when(this.creditCardJpaRepository.findByCreditCardNumber(ArgumentMatchers.anyString())).thenReturn(Optional.of(creditCardEntity));
        Mockito.when(this.creditCardJpaRepository.save(ArgumentMatchers.any())).thenReturn(creditCardEntity);

        final var response = this.creditCardAdapter.changeCreditCardStatus("123321", CreditCardStatusEnum.ALLOWED);

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
        Assertions.assertEquals(CreditCardStatusEnum.ALLOWED, response.getCreditCardStatus());
    }

    @Test
    void changeCreditCardStatusNotFoundCreditCardNOK() {
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        creditCardEntity.setCreditCardStatus(CreditCardStatusEnum.CANCELLED);
        Mockito.when(this.creditCardJpaRepository.findByCreditCardNumber(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        Mockito.when(this.creditCardJpaRepository.save(ArgumentMatchers.any())).thenReturn(creditCardEntity);

        Assertions.assertThrows(NotFoundException.class, () -> this.creditCardAdapter.changeCreditCardStatus("123321", CreditCardStatusEnum.ALLOWED));
    }

    @Test
    void validateCreditCardOk() {
        final var creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCreditCardId(1L);
        creditCardEntity.setCreditCardCvc("123");
        creditCardEntity.setCreditCardNumber("123321");
        creditCardEntity.setHolderName("Brayan Estrada");
        creditCardEntity.setMonthValidThru("12");
        creditCardEntity.setYearValidThru("27");
        creditCardEntity.setCreditCardStatus(CreditCardStatusEnum.CANCELLED);
        Mockito.when(this.creditCardJpaRepository.findByCreditCardNumber(ArgumentMatchers.anyString())).thenReturn(Optional.of(creditCardEntity));

        final var response = this.creditCardAdapter.validateCreditCard("123321");

        Assertions.assertEquals(1L, response.getCreditCardId());
        Assertions.assertEquals("123", response.getCreditCardCvc());
        Assertions.assertEquals("123321", response.getCreditCardNumber());
        Assertions.assertEquals("Brayan Estrada", response.getHolderName());
        Assertions.assertEquals("12", response.getMonthValidThru());
        Assertions.assertEquals("27", response.getYearValidThru());
        Assertions.assertEquals(CreditCardStatusEnum.CANCELLED, response.getCreditCardStatus());
    }
}
